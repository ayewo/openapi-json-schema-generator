package org.openapijsonschematools.client.paths.fakemultiplerequestbodycontenttypes.post.requestbody.content.applicationjson;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.StringJsonSchema;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.KeywordEntry;
import org.openapijsonschematools.client.schemas.validation.KeywordValidator;
import org.openapijsonschematools.client.schemas.validation.PropertiesValidator;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.TypeValidator;

public class Schema {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class A extends StringJsonSchema {}
    
    
    public static class SchemaMap extends FrozenMap<String, Object> {
        SchemaMap(FrozenMap<String, Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "a"
        );
        public static SchemaMap of(Map<String, Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Schema1.validate(arg, configuration);
        }
        
        public String a() {
            String key = "a";
            throwIfKeyNotPresent(key);
            return (String) get(key);
        }
        
        public Object getAdditionalProperty(String name) {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }    
    
    public static class Schema1 extends JsonSchema {
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenMap.class))),
            new KeywordEntry("properties", new PropertiesValidator(Map.ofEntries(
                new PropertyEntry("a", A.class)
            )))
        ));
        
        protected static SchemaMap getMapOutputInstance(FrozenMap<String, Object> arg) {
            return new SchemaMap(arg);
        }
        public static SchemaMap validate(Map<String, Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateMap(Schema1.class, arg, configuration);
        }
    }
}
