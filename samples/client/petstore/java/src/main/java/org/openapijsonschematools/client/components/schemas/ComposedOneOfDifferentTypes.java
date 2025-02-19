package org.openapijsonschematools.client.components.schemas;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.AnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.DateJsonSchema;
import org.openapijsonschematools.client.schemas.NullJsonSchema;
import org.openapijsonschematools.client.schemas.validation.FormatValidator;
import org.openapijsonschematools.client.schemas.validation.FrozenList;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.ItemsValidator;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.KeywordEntry;
import org.openapijsonschematools.client.schemas.validation.KeywordValidator;
import org.openapijsonschematools.client.schemas.validation.MaxItemsValidator;
import org.openapijsonschematools.client.schemas.validation.MaxPropertiesValidator;
import org.openapijsonschematools.client.schemas.validation.MinItemsValidator;
import org.openapijsonschematools.client.schemas.validation.MinPropertiesValidator;
import org.openapijsonschematools.client.schemas.validation.OneOfValidator;
import org.openapijsonschematools.client.schemas.validation.PatternValidator;
import org.openapijsonschematools.client.schemas.validation.TypeValidator;

public class ComposedOneOfDifferentTypes {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class Schema2 extends NullJsonSchema {}
    
    
    public static class Schema3 extends DateJsonSchema {}
    
    
    public static class Schema4 extends JsonSchema {
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenMap.class))),
            new KeywordEntry("maxProperties", new MaxPropertiesValidator(4)),
            new KeywordEntry("minProperties", new MinPropertiesValidator(4))
        ));
        public static FrozenMap<String, Object> validate(Map<String, Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateMap(Schema4.class, arg, configuration);
        }
    }
    
    
    public static class Items extends AnyTypeJsonSchema {}
    
    
    public static class Schema5List extends FrozenList<Object> {
        Schema5List(FrozenList<Object> m) {
            super(m);
        }
        public static Schema5List of(List<Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Schema5.validate(arg, configuration);
        }
    }
    
    
    public static class Schema5 extends JsonSchema {
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenList.class))),
            new KeywordEntry("items", new ItemsValidator(Items.class)),
            new KeywordEntry("maxItems", new MaxItemsValidator(4)),
            new KeywordEntry("minItems", new MinItemsValidator(4))
        ));
        
        protected static Schema5List getListOutputInstance(FrozenList<Object> arg) {
            return new Schema5List(arg);
        }
        public static Schema5List validate(List<Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateList(Schema5.class, arg, configuration);
        }
    }    
    
    public static class Schema6 extends JsonSchema {
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(
                String.class
            ))),
            new KeywordEntry("format", new FormatValidator("date-time")),
            new KeywordEntry("pattern", new PatternValidator(Pattern.compile(
                "^2020.*"
            )))
        ));
        public static String validate(String arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateString(Schema6.class, arg, configuration);
        }
    }    
    
    public static class ComposedOneOfDifferentTypes1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        this is a model that allows payloads of type object or number
        */
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("oneOf", new OneOfValidator(List.of(
                NumberWithValidations.NumberWithValidations1.class,
                Animal.Animal1.class,
                Schema2.class,
                Schema3.class,
                Schema4.class,
                Schema5.class,
                Schema6.class
            )))
        ));
        public static Void validate(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateVoid(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static boolean validate(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateBoolean(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static int validate(int arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateInt(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static long validate(long arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateLong(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static float validate(float arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateFloat(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static double validate(double arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateDouble(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static String validate(String arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateString(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static String validate(ZonedDateTime arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateZonedDateTime(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static String validate(LocalDate arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateLocalDate(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static String validate(UUID arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateUUID(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static FrozenMap<String, Object> validate(Map<String, Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateMap(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
        
        public static FrozenList<Object> validate(List<Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateList(ComposedOneOfDifferentTypes1.class, arg, configuration);
        }
    }}
