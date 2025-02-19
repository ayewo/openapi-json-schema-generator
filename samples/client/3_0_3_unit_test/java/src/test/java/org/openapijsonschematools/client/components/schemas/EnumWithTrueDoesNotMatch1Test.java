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

public class EnumWithTrueDoesNotMatch1Test {
    static final SchemaConfiguration configuration = new SchemaConfiguration(JsonSchemaKeywordFlags.ofNone());

    @Test
    public void testFloatOneIsInvalidFails() {
        // float one is invalid
        Assert.assertThrows(ValidationException.class, () -> JsonSchema.validate(
            EnumWithTrueDoesNotMatch1.EnumWithTrueDoesNotMatch11.class,
            1.0,
            configuration
        ));
    }

    @Test
    public void testIntegerOneIsInvalidFails() {
        // integer one is invalid
        Assert.assertThrows(ValidationException.class, () -> JsonSchema.validate(
            EnumWithTrueDoesNotMatch1.EnumWithTrueDoesNotMatch11.class,
            1,
            configuration
        ));
    }

    @Test
    public void testTrueIsValidPasses() {
        // true is valid
        EnumWithTrueDoesNotMatch1.EnumWithTrueDoesNotMatch11.validate(
            true,
            configuration
        );
    }
}
