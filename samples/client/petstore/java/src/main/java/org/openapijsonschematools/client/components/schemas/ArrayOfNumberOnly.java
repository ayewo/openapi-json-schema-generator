package org.openapijsonschematools.client.components.schemas;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.NumberJsonSchema;
import org.openapijsonschematools.client.schemas.validation.FrozenList;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.ItemsValidator;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.KeywordEntry;
import org.openapijsonschematools.client.schemas.validation.KeywordValidator;
import org.openapijsonschematools.client.schemas.validation.PropertiesValidator;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.TypeValidator;

public class ArrayOfNumberOnly {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class Items extends NumberJsonSchema {}
    
    
    public static class ArrayNumberList extends FrozenList<Number> {
        ArrayNumberList(FrozenList<Number> m) {
            super(m);
        }
        public static ArrayNumberList of(List<Number> arg, SchemaConfiguration configuration) throws ValidationException {
            return ArrayNumber.validate(arg, configuration);
        }
    }
    
    
    public static class ArrayNumber extends JsonSchema {
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenList.class))),
            new KeywordEntry("items", new ItemsValidator(Items.class))
        ));
        
        protected static ArrayNumberList getListOutputInstance(FrozenList<Number> arg) {
            return new ArrayNumberList(arg);
        }
        public static ArrayNumberList validate(List<Number> arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateList(ArrayNumber.class, arg, configuration);
        }
    }    
    
    public static class ArrayOfNumberOnlyMap extends FrozenMap<String, Object> {
        ArrayOfNumberOnlyMap(FrozenMap<String, Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "ArrayNumber"
        );
        public static ArrayOfNumberOnlyMap of(Map<String, Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return ArrayOfNumberOnly1.validate(arg, configuration);
        }
        
        public ArrayNumberList ArrayNumber() {
            String key = "ArrayNumber";
            throwIfKeyNotPresent(key);
            return (ArrayNumberList) get(key);
        }
        
        public Object getAdditionalProperty(String name) {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }    
    
    public static class ArrayOfNumberOnly1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenMap.class))),
            new KeywordEntry("properties", new PropertiesValidator(Map.ofEntries(
                new PropertyEntry("ArrayNumber", ArrayNumber.class)
            )))
        ));
        
        protected static ArrayOfNumberOnlyMap getMapOutputInstance(FrozenMap<String, Object> arg) {
            return new ArrayOfNumberOnlyMap(arg);
        }
        public static ArrayOfNumberOnlyMap validate(Map<String, Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateMap(ArrayOfNumberOnly1.class, arg, configuration);
        }
    }
}
