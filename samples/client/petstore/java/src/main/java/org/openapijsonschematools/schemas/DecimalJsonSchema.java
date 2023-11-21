package org.openapijsonschematools.schemas;

import org.openapijsonschematools.schemas.validation.JsonSchema;
import org.openapijsonschematools.configurations.SchemaConfiguration;
import org.openapijsonschematools.schemas.validation.KeywordEntry;
import org.openapijsonschematools.schemas.validation.KeywordValidator;
import org.openapijsonschematools.schemas.validation.TypeValidator;
import org.openapijsonschematools.schemas.validation.FormatValidator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class DecimalJsonSchema extends JsonSchema {
    public static final LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>(Map.ofEntries(
        new KeywordEntry("type", new TypeValidator(Set.of(String.class))),
        new KeywordEntry("format", new FormatValidator("number"))
    ));

    public static String validate(String arg, SchemaConfiguration configuration) {
        return JsonSchema.validate(DecimalJsonSchema.class, arg, configuration);
    }
}
