package org.openapijsonschematools.client.schemas.validation;

import org.openapijsonschematools.client.exceptions.ValidationException;


public class ExclusiveMaximumValidator implements KeywordValidator {
    public final Number exclusiveMaximum;

    public ExclusiveMaximumValidator(Number exclusiveMaximum) {
        this.exclusiveMaximum = exclusiveMaximum;
    }

    @Override
    public Object getConstraint() {
        return exclusiveMaximum;
    }

    @Override
    public PathToSchemasMap validate(Class<? extends JsonSchema> cls, Object arg, ValidationMetadata validationMetadata, Object extra) {
        if (!(arg instanceof Number)) {
            return null;
        }
        String msg = "Value " + arg + " is invalid because it is >= the exclusiveMaximum of " + exclusiveMaximum;
        if (arg instanceof Integer) {
            if (((Integer) arg).compareTo(exclusiveMaximum.intValue()) > -1) {
                throw new ValidationException(msg);
            }
            return null;
        }
        if (arg instanceof Long) {
            if (((Long) arg).compareTo(exclusiveMaximum.longValue()) > -1) {
                throw new ValidationException(msg);
            }
            return null;
        }
        if (arg instanceof Float) {
            if (((Float) arg).compareTo(exclusiveMaximum.floatValue()) > -1) {
                throw new ValidationException(msg);
            }
            return null;
        }
        if (arg instanceof Double) {
            if (((Double) arg).compareTo(exclusiveMaximum.doubleValue()) > -1) {
                throw new ValidationException(msg);
            }
            return null;
        }
        return null;
    }
}
