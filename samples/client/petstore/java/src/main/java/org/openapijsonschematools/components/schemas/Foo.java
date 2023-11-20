package org.openapijsonschematools.components.schemas;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.configurations.SchemaConfiguration;
import org.openapijsonschematools.schemas.validation.FrozenMap;
import org.openapijsonschematools.schemas.validation.JsonSchema;

public class Foo {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class FooMap extends FrozenMap<String, Object> {
        FooMap(FrozenMap<? extends String, ?> m) {
            super(m);
        }
        public static FooMap of(Map<String, Object> arg, SchemaConfiguration configuration) {
            return Foo1.validate(arg, configuration);
        }
    }    
    
    public class Foo1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenMap.class
        ));
        public static final LinkedHashMap<String, Class<?>> properties = new LinkedHashMap<>(Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Class<?>>("bar", Bar.Bar1.class)
        ));
        protected static FooMap getMapOutputInstance(FrozenMap<? extends String, ?> arg) {
            return new FooMap(arg);
        }
        public static FooMap validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(Foo1.class, arg, configuration);
        }
    }
}
