package org.openapijsonschematools.components.schemas;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.configurations.SchemaConfiguration;
import org.openapijsonschematools.schemas.DateTimeJsonSchema;
import org.openapijsonschematools.schemas.UuidJsonSchema;
import org.openapijsonschematools.schemas.validation.FrozenMap;
import org.openapijsonschematools.schemas.validation.JsonSchema;

public class MixedPropertiesAndAdditionalPropertiesClass {
    // nest classes so all schemas and input/output classes can be public
    
    
    public class UuidSchema extends UuidJsonSchema {}
    
    
    public class DateTime extends DateTimeJsonSchema {}
    
    
    public static class MapMap extends FrozenMap<String, Object> {
        MapMap(FrozenMap<? extends String, ?> m) {
            super(m);
        }
        public static MapMap of(Map<String, Object> arg, SchemaConfiguration configuration) {
            return MapSchema.validate(arg, configuration);
        }
    }    
    
    public class MapSchema extends JsonSchema {
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenMap.class
        ));
        static final Class<?> additionalProperties = Animal.Animal1.class;
        protected static MapMap getMapOutputInstance(FrozenMap<? extends String, ?> arg) {
            return new MapMap(arg);
        }
        public static MapMap validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(MapSchema.class, arg, configuration);
        }
    }
    
    
    public static class MixedPropertiesAndAdditionalPropertiesClassMap extends FrozenMap<String, Object> {
        MixedPropertiesAndAdditionalPropertiesClassMap(FrozenMap<? extends String, ?> m) {
            super(m);
        }
        public static MixedPropertiesAndAdditionalPropertiesClassMap of(Map<String, Object> arg, SchemaConfiguration configuration) {
            return MixedPropertiesAndAdditionalPropertiesClass1.validate(arg, configuration);
        }
    }    
    
    public class MixedPropertiesAndAdditionalPropertiesClass1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenMap.class
        ));
        public static final LinkedHashMap<String, Class<?>> properties = new LinkedHashMap<>(Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Class<?>>("uuid", UuidSchema.class),
            new AbstractMap.SimpleEntry<String, Class<?>>("dateTime", DateTime.class),
            new AbstractMap.SimpleEntry<String, Class<?>>("map", MapSchema.class)
        ));
        protected static MixedPropertiesAndAdditionalPropertiesClassMap getMapOutputInstance(FrozenMap<? extends String, ?> arg) {
            return new MixedPropertiesAndAdditionalPropertiesClassMap(arg);
        }
        public static MixedPropertiesAndAdditionalPropertiesClassMap validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(MixedPropertiesAndAdditionalPropertiesClass1.class, arg, configuration);
        }
    }
}
