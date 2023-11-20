package org.openapijsonschematools.components.schemas;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openapijsonschematools.configurations.SchemaConfiguration;
import org.openapijsonschematools.schemas.validation.FrozenList;
import org.openapijsonschematools.schemas.validation.FrozenMap;
import org.openapijsonschematools.schemas.validation.JsonSchema;

public class AdditionalPropertiesWithArrayOfEnums {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class AdditionalPropertiesList extends FrozenList<Object> {
        AdditionalPropertiesList(FrozenList<Object> m) {
            super(m);
        }
    }    
    
    public class AdditionalProperties extends JsonSchema {
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenList.class
        ));
        public static final Class<?> items = EnumClass.EnumClass1.class;
        protected static AdditionalPropertiesList getListOutputInstance(FrozenList<Object> arg) {
            return new AdditionalPropertiesList(arg);
        }
        public static AdditionalPropertiesList validate(List<Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(AdditionalProperties.class, arg, configuration);
        }
    }    
    
    public static class AdditionalPropertiesWithArrayOfEnumsMap extends FrozenMap<String, Object> {
        AdditionalPropertiesWithArrayOfEnumsMap(FrozenMap<? extends String, ?> m) {
            super(m);
        }
        public static AdditionalPropertiesWithArrayOfEnumsMap of(Map<String, Object> arg, SchemaConfiguration configuration) {
            return AdditionalPropertiesWithArrayOfEnums1.validate(arg, configuration);
        }
    }    
    
    public class AdditionalPropertiesWithArrayOfEnums1 extends JsonSchema {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        public static final LinkedHashSet<Class<?>> type = new LinkedHashSet<>(Set.of(
            FrozenMap.class
        ));
        static final Class<?> additionalProperties = AdditionalProperties.class;
        protected static AdditionalPropertiesWithArrayOfEnumsMap getMapOutputInstance(FrozenMap<? extends String, ?> arg) {
            return new AdditionalPropertiesWithArrayOfEnumsMap(arg);
        }
        public static AdditionalPropertiesWithArrayOfEnumsMap validate(Map<String, Object> arg, SchemaConfiguration configuration) {
            return JsonSchema.validate(AdditionalPropertiesWithArrayOfEnums1.class, arg, configuration);
        }
    }
}
