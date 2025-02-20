package org.openapijsonschematools.client.components.schemas;

import org.junit.Assert;
import org.junit.Test;
import org.openapijsonschematools.client.configurations.JsonSchemaKeywordFlags;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.MapMaker;

import java.util.Arrays;
import java.util.List;
import java.util.AbstractMap;

public class AllofSimpleTypesTest {
    static final SchemaConfiguration configuration = new SchemaConfiguration(JsonSchemaKeywordFlags.ofNone());

    @Test
    public void testMismatchOneFails() {
        // mismatch one
        Assert.assertThrows(ValidationException.class, () -> JsonSchema.validate(
            AllofSimpleTypes.AllofSimpleTypes1.class,
            35,
            configuration
        ));
    }

    @Test
    public void testValidPasses() {
        // valid
        AllofSimpleTypes.AllofSimpleTypes1.validate(
            25,
            configuration
        );
    }
}
