package org.openapijsonschematools.client.schemas;

import org.junit.Assert;
import org.junit.Test;
import org.openapijsonschematools.client.configurations.JsonSchemaKeywordFlags;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.schemas.validation.FrozenList;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class AnyTypeSchemaTest {
    static final SchemaConfiguration configuration = new SchemaConfiguration(JsonSchemaKeywordFlags.ofNone());

    @Test
    public void testValidateNull() {
        Void validatedValue = AnyTypeJsonSchema.validate((Void) null, configuration);
        Assert.assertNull(validatedValue);
    }

    @Test
    public void testValidateBoolean() {
        boolean trueValue = AnyTypeJsonSchema.validate(true, configuration);
        Assert.assertEquals(trueValue, true);

        boolean falseValue = AnyTypeJsonSchema.validate(false, configuration);
        Assert.assertEquals(falseValue, false);
    }

    @Test
    public void testValidateInteger() {
        int validatedValue = AnyTypeJsonSchema.validate(1, configuration);
        Assert.assertEquals(validatedValue, 1);
    }

    @Test
    public void testValidateLong() {
        long validatedValue = AnyTypeJsonSchema.validate(1L, configuration);
        Assert.assertEquals(validatedValue, 1L);
    }

    @Test
    public void testValidateFloat() {
        float validatedValue = AnyTypeJsonSchema.validate(3.14f, configuration);
        Assert.assertEquals(Float.compare(validatedValue, 3.14f), 0);
    }

    @Test
    public void testValidateDouble() {
        double validatedValue = AnyTypeJsonSchema.validate(70.6458763d, configuration);
        Assert.assertEquals(Double.compare(validatedValue, 70.6458763d), 0);
    }

    @Test
    public void testValidateString() {
        String validatedValue = AnyTypeJsonSchema.validate("a", configuration);
        Assert.assertEquals(validatedValue, "a");
    }

    @Test
    public void testValidateZonedDateTime() {
        String validatedValue = AnyTypeJsonSchema.validate(ZonedDateTime.of(2017, 7, 21, 17, 32, 28, 0, ZoneId.of("Z")), configuration);
        Assert.assertEquals(validatedValue, "2017-07-21T17:32:28Z");
    }

    @Test
    public void testValidateLocalDate() {
        String validatedValue = AnyTypeJsonSchema.validate(LocalDate.of(2017, 7, 21), configuration);
        Assert.assertEquals(validatedValue, "2017-07-21");
    }

    @Test
    public void testValidateMap() {
        LinkedHashMap<String, Object> inMap = new LinkedHashMap<>();
        inMap.put("today", LocalDate.of(2017, 7, 21));
        FrozenMap<String, Object> validatedValue = AnyTypeJsonSchema.validate(inMap, configuration);
        LinkedHashMap<String, Object> outMap = new LinkedHashMap<>();
        outMap.put("today", "2017-07-21");
        Assert.assertEquals(validatedValue, outMap);
    }

    @Test
    public void testValidateList() {
        ArrayList<Object> inList = new ArrayList<>();
        inList.add(LocalDate.of(2017, 7, 21));
        FrozenList<Object> validatedValue = AnyTypeJsonSchema.validate(inList, configuration);
        ArrayList<Object> outList = new ArrayList<>();
        outList.add( "2017-07-21");
        Assert.assertEquals(validatedValue, outList);
    }
}
