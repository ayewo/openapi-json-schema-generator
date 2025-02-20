package org.openapijsonschematools.client.components.schemas;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.IntJsonSchema;
import org.openapijsonschematools.client.schemas.validation.AdditionalPropertiesValidator;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.KeywordEntry;
import org.openapijsonschematools.client.schemas.validation.KeywordValidator;
import org.openapijsonschematools.client.schemas.validation.TypeValidator;

public class Address {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class AdditionalProperties extends IntJsonSchema {}
    
    
    public static class AddressMap extends FrozenMap<String, Long> {
        AddressMap(FrozenMap<String, Long> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of();
        public static AddressMap of(Map<String, Long> arg, SchemaConfiguration configuration) throws ValidationException {
            return Address1.validate(arg, configuration);
        }
        
        public long getAdditionalProperty(String name) {
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }    
    
    public static class Address1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenMap.class))),
            new KeywordEntry("additionalProperties", new AdditionalPropertiesValidator(AdditionalProperties.class))
        ));
        
        protected static AddressMap getMapOutputInstance(FrozenMap<String, Long> arg) {
            return new AddressMap(arg);
        }
        public static AddressMap validate(Map<String, Long> arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateMap(Address1.class, arg, configuration);
        }
    }
}
