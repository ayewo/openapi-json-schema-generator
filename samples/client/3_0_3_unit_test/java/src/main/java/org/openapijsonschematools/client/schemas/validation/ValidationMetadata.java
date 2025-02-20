package org.openapijsonschematools.client.schemas.validation;

import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record ValidationMetadata(
        List<Object> pathToItem,
        SchemaConfiguration configuration,
        PathToSchemasMap validatedPathToSchemas,
        Set<Class<?>> seenClasses
) {

    public boolean validationRanEarlier(Class<? extends JsonSchema> cls) {
        Map<Class<? extends JsonSchema>, Void> validatedSchemas = validatedPathToSchemas.getOrDefault(pathToItem, null);
        if (validatedSchemas != null && validatedSchemas.containsKey(cls)) {
            return true;
        }
        if (seenClasses.contains(cls)) {
            return true;
        }
        return false;
    }

}