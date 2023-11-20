package org.openapijsonschematools.components.schemas;
import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.configurations.SchemaConfiguration;
import org.openapijsonschematools.schemas.Int64JsonSchema;
import org.openapijsonschematools.schemas.StringJsonSchema;
import org.openapijsonschematools.schemas.validation.FrozenList;
import org.openapijsonschematools.schemas.validation.FrozenMap;
import org.openapijsonschematools.schemas.validation.JsonSchema;

public class Pet {
    // nest classes so all schemas and input/output classes can be public
    
    
    public class Id extends Int64JsonSchema {}
    
    
    public class Name extends StringJsonSchema {}
    
    
    public class Items extends StringJsonSchema {}
    
    
    public static class PhotoUrlsList extends FrozenList<Object> {
        PhotoUrlsList(FrozenList<Object> m) {
            super(m);
        }
    }    
    
    public class PhotoUrls extends JsonSchema {
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenList.class
        ));
        public static final Class<?> items = Items.class;
        protected static PhotoUrlsList getListOutputInstance(FrozenList<Object> arg) {
            return new PhotoUrlsList(arg);
        }
        public static PhotoUrlsList validate(List<Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(PhotoUrls.class, arg, configuration);
        }
    }    
    
    public class Status extends JsonSchema {
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            String.class
        ));
        public static String validate(String arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(Status.class, arg, configuration);
        }
    }    
    
    public static class TagsList extends FrozenList<Object> {
        TagsList(FrozenList<Object> m) {
            super(m);
        }
    }    
    
    public class Tags extends JsonSchema {
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenList.class
        ));
        public static final Class<?> items = Tag.Tag1.class;
        protected static TagsList getListOutputInstance(FrozenList<Object> arg) {
            return new TagsList(arg);
        }
        public static TagsList validate(List<Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(Tags.class, arg, configuration);
        }
    }    
    
    public static class PetMap extends FrozenMap<String, Object> {
        PetMap(FrozenMap<? extends String, ?> m) {
            super(m);
        }
        public static PetMap of(Map<String, Object> arg, SchemaConfiguration configuration) {
            return Pet1.validate(arg, configuration);
        }
    }    
    
    public class Pet1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Pet object that needs to be added to the store
        */
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenMap.class
        ));
        public static final LinkedHashMap<String, Class<?>> properties = new LinkedHashMap<>(Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Class<?>>("id", Id.class),
            new AbstractMap.SimpleEntry<String, Class<?>>("category", Category.Category1.class),
            new AbstractMap.SimpleEntry<String, Class<?>>("name", Name.class),
            new AbstractMap.SimpleEntry<String, Class<?>>("photoUrls", PhotoUrls.class),
            new AbstractMap.SimpleEntry<String, Class<?>>("tags", Tags.class),
            new AbstractMap.SimpleEntry<String, Class<?>>("status", Status.class)
        ));
        public static final Set<String> required = new LinkedHashSet<>(Set.of(
            "name",
            "photoUrls"
        ));
        protected static PetMap getMapOutputInstance(FrozenMap<? extends String, ?> arg) {
            return new PetMap(arg);
        }
        public static PetMap validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(Pet1.class, arg, configuration);
        }
    }
}
