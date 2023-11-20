package org.openapijsonschematools.components.schemas;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.configurations.SchemaConfiguration;
import org.openapijsonschematools.schemas.AnyTypeJsonSchema;
import org.openapijsonschematools.schemas.NotAnyTypeJsonSchema;
import org.openapijsonschematools.schemas.UuidJsonSchema;
import org.openapijsonschematools.schemas.validation.FrozenMap;
import org.openapijsonschematools.schemas.validation.JsonSchema;

public class MyObjectDto {
    // nest classes so all schemas and input/output classes can be public
    
    
    public class AdditionalProperties extends NotAnyTypeJsonSchema {}
        // NotAnyTypeSchema
    
    
    public class Id extends UuidJsonSchema {}
    
    
    public static class MyObjectDtoMap extends FrozenMap<String, Object> {
        MyObjectDtoMap(FrozenMap<? extends String, ?> m) {
            super(m);
        }
        public static MyObjectDtoMap of(Map<String, Object> arg, SchemaConfiguration configuration) {
            return MyObjectDto1.validate(arg, configuration);
        }
    }    
    
    public class MyObjectDto1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenMap.class
        ));
        public static final LinkedHashMap<String, Class<?>> properties = new LinkedHashMap<>(Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Class<?>>("id", Id.class)
        ));
        static final Class<?> additionalProperties = AdditionalProperties.class;
        protected static MyObjectDtoMap getMapOutputInstance(FrozenMap<? extends String, ?> arg) {
            return new MyObjectDtoMap(arg);
        }
        public static MyObjectDtoMap validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(MyObjectDto1.class, arg, configuration);
        }
    }
}
