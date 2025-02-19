package org.openapijsonschematools.client.components.schemas;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.MapJsonSchema;
import org.openapijsonschematools.client.schemas.validation.FrozenList;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.ItemsValidator;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.KeywordEntry;
import org.openapijsonschematools.client.schemas.validation.KeywordValidator;
import org.openapijsonschematools.client.schemas.validation.TypeValidator;

public class Items {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class Items2 extends MapJsonSchema {}
    
    
    public static class ItemsList extends FrozenList<FrozenMap<String, Object>> {
        ItemsList(FrozenList<FrozenMap<String, Object>> m) {
            super(m);
        }
        public static ItemsList of(List<Map<String, Object>> arg, SchemaConfiguration configuration) throws ValidationException {
            return Items1.validate(arg, configuration);
        }
    }
    
    
    public static class Items1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        component's name collides with the inner schema name
        */
        public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
            new KeywordEntry("type", new TypeValidator(Set.of(FrozenList.class))),
            new KeywordEntry("items", new ItemsValidator(Items2.class))
        ));
        
        protected static ItemsList getListOutputInstance(FrozenList<FrozenMap<String, Object>> arg) {
            return new ItemsList(arg);
        }
        public static ItemsList validate(List<Map<String, Object>> arg, SchemaConfiguration configuration) throws ValidationException {
            return JsonSchema.validateList(Items1.class, arg, configuration);
        }
    }}
