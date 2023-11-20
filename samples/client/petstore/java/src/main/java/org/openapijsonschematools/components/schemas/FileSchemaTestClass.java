package org.openapijsonschematools.components.schemas;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.configurations.SchemaConfiguration;
import org.openapijsonschematools.schemas.validation.FrozenList;
import org.openapijsonschematools.schemas.validation.FrozenMap;
import org.openapijsonschematools.schemas.validation.JsonSchema;

public class FileSchemaTestClass {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class FilesList extends FrozenList<Object> {
        FilesList(FrozenList<Object> m) {
            super(m);
        }
    }    
    
    public class Files extends JsonSchema {
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenList.class
        ));
        public static final Class<?> items = File.File1.class;
        protected static FilesList getListOutputInstance(FrozenList<Object> arg) {
            return new FilesList(arg);
        }
        public static FilesList validate(List<Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(Files.class, arg, configuration);
        }
    }    
    
    public static class FileSchemaTestClassMap extends FrozenMap<String, Object> {
        FileSchemaTestClassMap(FrozenMap<? extends String, ?> m) {
            super(m);
        }
        public static FileSchemaTestClassMap of(Map<String, Object> arg, SchemaConfiguration configuration) {
            return FileSchemaTestClass1.validate(arg, configuration);
        }
    }    
    
    public class FileSchemaTestClass1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenMap.class
        ));
        public static final LinkedHashMap<String, Class<?>> properties = new LinkedHashMap<>(Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Class<?>>("file", File.File1.class),
            new AbstractMap.SimpleEntry<String, Class<?>>("files", Files.class)
        ));
        protected static FileSchemaTestClassMap getMapOutputInstance(FrozenMap<? extends String, ?> arg) {
            return new FileSchemaTestClassMap(arg);
        }
        public static FileSchemaTestClassMap validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(FileSchemaTestClass1.class, arg, configuration);
        }
    }
}
