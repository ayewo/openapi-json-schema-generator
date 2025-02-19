package org.openapijsonschematools.client.schemas;

import org.junit.Assert;
import org.junit.Test;
import org.openapijsonschematools.client.configurations.JsonSchemaKeywordFlags;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.schemas.validation.AdditionalPropertiesValidator;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.KeywordEntry;
import org.openapijsonschematools.client.schemas.validation.KeywordValidator;
import org.openapijsonschematools.client.schemas.validation.PropertiesValidator;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.TypeValidator;
import org.openapijsonschematools.client.exceptions.ValidationException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class ObjectTypeSchemaTest {
    static final SchemaConfiguration configuration = new SchemaConfiguration(JsonSchemaKeywordFlags.ofNone());

    public class ObjectWithPropsSchema extends JsonSchema {
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenMap.class))),
            new KeywordEntry("properties", new PropertiesValidator(Map.ofEntries(
                new PropertyEntry("someString", StringJsonSchema.class)
            )))
        ));

        public static FrozenMap<String, Object> validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validateMap(ObjectWithPropsSchema.class, arg, configuration);
        }
    }

    public class ObjectWithAddpropsSchema extends JsonSchema {
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenMap.class))),
            new KeywordEntry("additionalProperties", new AdditionalPropertiesValidator(StringJsonSchema.class))
        ));

        public static FrozenMap<String, Object> validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validateMap(ObjectWithAddpropsSchema.class, arg, configuration);
        }
    }

    public class ObjectWithPropsAndAddpropsSchema extends JsonSchema {
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenMap.class))),
            new KeywordEntry("properties", new PropertiesValidator(Map.ofEntries(
                    new PropertyEntry("someString", StringJsonSchema.class)
            ))),
            new KeywordEntry("additionalProperties", new AdditionalPropertiesValidator(BooleanJsonSchema.class))
        ));

        public static FrozenMap<String, Object> validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validateMap(ObjectWithPropsAndAddpropsSchema.class, arg, configuration);
        }
    }

    public static class ObjectWithOutputTypeSchemaMap extends FrozenMap<String, Object> {
        ObjectWithOutputTypeSchemaMap(FrozenMap<? extends String, ?> m) {
            super(m);
        }

        public static ObjectWithOutputTypeSchemaMap of(Map<String, Object> arg, SchemaConfiguration configuration) {
            return ObjectWithOutputTypeSchema.validate(arg, configuration);
        }
    }


    public class ObjectWithOutputTypeSchema extends JsonSchema {
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenMap.class))),
            new KeywordEntry("properties", new PropertiesValidator(Map.ofEntries(
                new PropertyEntry("someString", StringJsonSchema.class)
            )))
        ));

        protected static ObjectWithOutputTypeSchemaMap getMapOutputInstance(FrozenMap<? extends String, ?> arg) {
            return new ObjectWithOutputTypeSchemaMap(arg);
        }

        public static ObjectWithOutputTypeSchemaMap validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validateMap(ObjectWithOutputTypeSchema.class, arg, configuration);
        }
    }

    @Test
    public void testExceptionThrownForInvalidType() {
        Assert.assertThrows(ValidationException.class, () -> JsonSchema.validate(
                ObjectWithPropsSchema.class, (Void) null, configuration
        ));
    }

    @Test
    public void testValidateObjectWithPropsSchema() {
        // map with only property works
        Map<String, Object> inMap = new LinkedHashMap<>();
        inMap.put("someString", "abc");
        FrozenMap<String, Object> validatedValue = ObjectWithPropsSchema.validate(inMap, configuration);
        LinkedHashMap<String, String> outMap = new LinkedHashMap<>();
        outMap.put("someString", "abc");
        Assert.assertEquals(validatedValue, outMap);

        // map with additional unvalidated property works
        inMap = new LinkedHashMap<>();
        inMap.put("someString", "abc");
        inMap.put("someOtherString", "def");
        validatedValue = ObjectWithPropsSchema.validate(inMap, configuration);
        outMap = new LinkedHashMap<>();
        outMap.put("someString", "abc");
        outMap.put("someOtherString", "def");
        Assert.assertEquals(validatedValue, outMap);

        // invalid prop type fails
        inMap = new LinkedHashMap<>();
        inMap.put("someString", 1);
        Map<String, Object> finalInMap = inMap;
        Assert.assertThrows(ValidationException.class, () -> ObjectWithPropsSchema.validate(
                finalInMap, configuration
        ));
    }

    @Test
    public void testValidateObjectWithAddpropsSchema() {
        // map with only property works
        Map<String, Object> inMap = new LinkedHashMap<>();
        inMap.put("someString", "abc");
        FrozenMap<String, Object> validatedValue = ObjectWithAddpropsSchema.validate(inMap, configuration);
        LinkedHashMap<String, String> outMap = new LinkedHashMap<>();
        outMap.put("someString", "abc");
        Assert.assertEquals(validatedValue, outMap);

        // map with additional properties works
        inMap = new LinkedHashMap<>();
        inMap.put("someString", "abc");
        inMap.put("someOtherString", "def");
        validatedValue = ObjectWithAddpropsSchema.validate(inMap, configuration);
        outMap = new LinkedHashMap<>();
        outMap.put("someString", "abc");
        outMap.put("someOtherString", "def");
        Assert.assertEquals(validatedValue, outMap);

        // invalid addProp type fails
        inMap = new LinkedHashMap<>();
        inMap.put("someString", 1);
        Map<String, Object> finalInMap = inMap;
        Assert.assertThrows(ValidationException.class, () -> ObjectWithAddpropsSchema.validate(
                finalInMap, configuration
        ));
    }

    @Test
    public void testValidateObjectWithPropsAndAddpropsSchema() {
        // map with only property works
        Map<String, Object> inMap = new LinkedHashMap<>();
        inMap.put("someString", "abc");
        FrozenMap<String, Object> validatedValue = ObjectWithPropsAndAddpropsSchema.validate(inMap, configuration);
        LinkedHashMap<String, Object> outMap = new LinkedHashMap<>();
        outMap.put("someString", "abc");
        Assert.assertEquals(validatedValue, outMap);

        // map with additional properties works
        inMap = new LinkedHashMap<>();
        inMap.put("someString", "abc");
        inMap.put("someAddProp", true);
        validatedValue = ObjectWithPropsAndAddpropsSchema.validate(inMap, configuration);
        outMap = new LinkedHashMap<>();
        outMap.put("someString", "abc");
        outMap.put("someAddProp", true);
        Assert.assertEquals(validatedValue, outMap);

        // invalid prop type fails
        inMap = new LinkedHashMap<>();
        inMap.put("someString", 1);
        Map<String, Object> invalidPropMap = inMap;
        Assert.assertThrows(ValidationException.class, () -> ObjectWithPropsAndAddpropsSchema.validate(
                invalidPropMap, configuration
        ));

        // invalid addProp type fails
        inMap = new LinkedHashMap<>();
        inMap.put("someAddProp", 1);
        Map<String, Object> invalidAddpropMap = inMap;
        Assert.assertThrows(ValidationException.class, () -> ObjectWithPropsAndAddpropsSchema.validate(
                invalidAddpropMap, configuration
        ));
    }

    @Test
    public void testValidateObjectWithOutputTypeSchema() {
        // map with only property works
        Map<String, Object> inMap = new LinkedHashMap<>();
        inMap.put("someString", "abc");
        ObjectWithOutputTypeSchemaMap validatedValue = ObjectWithOutputTypeSchema.validate(inMap, configuration);
        LinkedHashMap<String, String> outMap = new LinkedHashMap<>();
        outMap.put("someString", "abc");
        Assert.assertEquals(validatedValue, outMap);

        // map with additional unvalidated property works
        inMap = new LinkedHashMap<>();
        inMap.put("someString", "abc");
        inMap.put("someOtherString", "def");
        validatedValue = ObjectWithOutputTypeSchema.validate(inMap, configuration);
        outMap = new LinkedHashMap<>();
        outMap.put("someString", "abc");
        outMap.put("someOtherString", "def");
        Assert.assertEquals(validatedValue, outMap);

        // invalid prop type fails
        inMap = new LinkedHashMap<>();
        inMap.put("someString", 1);
        Map<String, Object> finalInMap = inMap;
        Assert.assertThrows(ValidationException.class, () -> ObjectWithOutputTypeSchema.validate(
                finalInMap, configuration
        ));

        // using output class directly works
        inMap = new LinkedHashMap<>();
        inMap.put("someString", "abc");
        validatedValue = ObjectWithOutputTypeSchemaMap.of(inMap, configuration);
        outMap = new LinkedHashMap<>();
        outMap.put("someString", "abc");
        Assert.assertEquals(validatedValue, outMap);
    }
}
