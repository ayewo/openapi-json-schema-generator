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

public class AllofWithBaseSchemaTest {
    static final SchemaConfiguration configuration = new SchemaConfiguration(JsonSchemaKeywordFlags.ofNone());

    @Test
    public void testMismatchBaseSchemaFails() {
        // mismatch base schema
        Assert.assertThrows(ValidationException.class, () -> JsonSchema.validate(
            AllofWithBaseSchema.AllofWithBaseSchema1.class,
            MapMaker.makeMap(
                new AbstractMap.SimpleEntry<>(
                    "foo",
                    "quux"
                ),
                new AbstractMap.SimpleEntry<>(
                    "baz",
                    (Void) null
                )
            ),
            configuration
        ));
    }

    @Test
    public void testMismatchFirstAllofFails() {
        // mismatch first allOf
        Assert.assertThrows(ValidationException.class, () -> JsonSchema.validate(
            AllofWithBaseSchema.AllofWithBaseSchema1.class,
            MapMaker.makeMap(
                new AbstractMap.SimpleEntry<>(
                    "bar",
                    2
                ),
                new AbstractMap.SimpleEntry<>(
                    "baz",
                    (Void) null
                )
            ),
            configuration
        ));
    }

    @Test
    public void testValidPasses() {
        // valid
        AllofWithBaseSchema.AllofWithBaseSchema1.validate(
            MapMaker.makeMap(
                new AbstractMap.SimpleEntry<>(
                    "foo",
                    "quux"
                ),
                new AbstractMap.SimpleEntry<>(
                    "bar",
                    2
                ),
                new AbstractMap.SimpleEntry<>(
                    "baz",
                    (Void) null
                )
            ),
            configuration
        );
    }

    @Test
    public void testMismatchBothFails() {
        // mismatch both
        Assert.assertThrows(ValidationException.class, () -> JsonSchema.validate(
            AllofWithBaseSchema.AllofWithBaseSchema1.class,
            MapMaker.makeMap(
                new AbstractMap.SimpleEntry<>(
                    "bar",
                    2
                )
            ),
            configuration
        ));
    }

    @Test
    public void testMismatchSecondAllofFails() {
        // mismatch second allOf
        Assert.assertThrows(ValidationException.class, () -> JsonSchema.validate(
            AllofWithBaseSchema.AllofWithBaseSchema1.class,
            MapMaker.makeMap(
                new AbstractMap.SimpleEntry<>(
                    "foo",
                    "quux"
                ),
                new AbstractMap.SimpleEntry<>(
                    "bar",
                    2
                )
            ),
            configuration
        ));
    }
}
