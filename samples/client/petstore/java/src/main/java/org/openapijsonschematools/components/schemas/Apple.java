package org.openapijsonschematools.components.schemas;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.configurations.SchemaConfiguration;
import org.openapijsonschematools.schemas.validation.FrozenMap;
import org.openapijsonschematools.schemas.validation.JsonSchema;

public class Apple {
    // nest classes so all schemas and input/output classes can be public
    
    
    public class Cultivar extends JsonSchema {
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            String.class
        ));
        public static String validate(String arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(Cultivar.class, arg, configuration);
        }
    }    
    
    public class Origin extends JsonSchema {
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            String.class
        ));
        public static String validate(String arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(Origin.class, arg, configuration);
        }
    }    
    
    public static class AppleMap extends FrozenMap<String, Object> {
        AppleMap(FrozenMap<? extends String, ?> m) {
            super(m);
        }
        public static AppleMap of(Map<String, Object> arg, SchemaConfiguration configuration) {
            return Apple1.validate(arg, configuration);
        }
    }    
    
    public class Apple1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            Void.class,
            FrozenMap.class
        ));
        public static final LinkedHashMap<String, Class<?>> properties = new LinkedHashMap<>(Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Class<?>>("cultivar", Cultivar.class),
            new AbstractMap.SimpleEntry<String, Class<?>>("origin", Origin.class)
        ));
        public static final Set<String> required = new LinkedHashSet<>(Set.of(
            "cultivar"
        ));
        public static Void validate(Void arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(Apple1.class, arg, configuration);
        }
        public static AppleMap validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(Apple1.class, arg, configuration);
        }
    }}
