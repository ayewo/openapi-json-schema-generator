package org.openapijsonschematools.components.schemas;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.configurations.SchemaConfiguration;
import org.openapijsonschematools.schemas.AnyTypeJsonSchema;
import org.openapijsonschematools.schemas.IntJsonSchema;
import org.openapijsonschematools.schemas.NotAnyTypeJsonSchema;
import org.openapijsonschematools.schemas.validation.FrozenList;
import org.openapijsonschematools.schemas.validation.FrozenMap;
import org.openapijsonschematools.schemas.validation.JsonSchema;

public class PaginatedResultMyObjectDto {
    // nest classes so all schemas and input/output classes can be public
    
    
    public class AdditionalProperties extends NotAnyTypeJsonSchema {}
        // NotAnyTypeSchema
    
    
    public class Count extends IntJsonSchema {}
    
    
    public static class ResultsList extends FrozenList<Object> {
        ResultsList(FrozenList<Object> m) {
            super(m);
        }
    }    
    
    public class Results extends JsonSchema {
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenList.class
        ));
        public static final Class<?> items = MyObjectDto.MyObjectDto1.class;
        protected static ResultsList getListOutputInstance(FrozenList<Object> arg) {
            return new ResultsList(arg);
        }
        public static ResultsList validate(List<Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(Results.class, arg, configuration);
        }
    }    
    
    public static class PaginatedResultMyObjectDtoMap extends FrozenMap<String, Object> {
        PaginatedResultMyObjectDtoMap(FrozenMap<? extends String, ?> m) {
            super(m);
        }
        public static PaginatedResultMyObjectDtoMap of(Map<String, Object> arg, SchemaConfiguration configuration) {
            return PaginatedResultMyObjectDto1.validate(arg, configuration);
        }
    }    
    
    public class PaginatedResultMyObjectDto1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenMap.class
        ));
        public static final LinkedHashMap<String, Class<?>> properties = new LinkedHashMap<>(Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Class<?>>("count", Count.class),
            new AbstractMap.SimpleEntry<String, Class<?>>("results", Results.class)
        ));
        public static final Set<String> required = new LinkedHashSet<>(Set.of(
            "count",
            "results"
        ));
        static final Class<?> additionalProperties = AdditionalProperties.class;
        protected static PaginatedResultMyObjectDtoMap getMapOutputInstance(FrozenMap<? extends String, ?> arg) {
            return new PaginatedResultMyObjectDtoMap(arg);
        }
        public static PaginatedResultMyObjectDtoMap validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(PaginatedResultMyObjectDto1.class, arg, configuration);
        }
    }
}
