package org.openapijsonschematools.client.schemas.validation;

import org.openapijsonschematools.client.configurations.JsonSchemaKeywordFlags;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.exceptions.InvalidTypeException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public abstract class JsonSchema {
    protected static PathToSchemasMap validate(
            Class<? extends JsonSchema> schemaCls,
            Object arg,
            ValidationMetadata validationMetadata
    ) throws ValidationException {
        LinkedHashSet<String> disabledKeywords = validationMetadata.configuration().disabledKeywordFlags().getKeywords();
        Class<? extends JsonSchema> usedSchemaCls = schemaCls;
        Class<?> superclass = schemaCls.getSuperclass();
        if (superclass != JsonSchema.class) {
            // only ref with no adjacent properties supported at this time
            usedSchemaCls = (Class<? extends JsonSchema>) superclass;
        }
        LinkedHashMap<String, KeywordValidator> keywordToValidator = new LinkedHashMap<>();
        try {
            Field keywordToValidatorField = usedSchemaCls.getField("keywordToValidator");
            LinkedHashMap<String, KeywordValidator> entries = (LinkedHashMap<String, KeywordValidator>) keywordToValidatorField.get(null);
            keywordToValidator.putAll(entries);
            keywordToValidator.keySet().removeAll(disabledKeywords);
        } catch (NoSuchFieldException | IllegalAccessException ignore) {}
        Object extra = null;
        PathToSchemasMap pathToSchemas = new PathToSchemasMap();
        for (Map.Entry<String, KeywordValidator> entry: keywordToValidator.entrySet()) {
            String jsonKeyword = entry.getKey();
            if (jsonKeyword.equals("additionalProperties") && keywordToValidator.containsKey("properties")) {
                extra = keywordToValidator.get("properties").getConstraint();
            }
            KeywordValidator validator = entry.getValue();
            PathToSchemasMap otherPathToSchemas = validator.validate(
                    schemaCls,
                    arg,
                    validationMetadata,
                    extra
            );
            if (otherPathToSchemas == null) {
                continue;
            }
            pathToSchemas.update(otherPathToSchemas);
        }
        List<Object> pathToItem = validationMetadata.pathToItem();
        if (!pathToSchemas.containsKey(pathToItem)) {
            pathToSchemas.put(validationMetadata.pathToItem(), new LinkedHashMap<>());
        }
        pathToSchemas.get(pathToItem).put(schemaCls, null);

        return pathToSchemas;
    }

   private static Object castToAllowedTypes(Object arg, List<Object> pathToItem, Set<List<Object>> pathSet) {
      if (arg == null) {
         pathSet.add(pathToItem);
         return null;
      } else if (arg instanceof String) {
         pathSet.add(pathToItem);
         return arg;
      } else if (arg instanceof Map) {
         pathSet.add(pathToItem);
         LinkedHashMap<String, Object> argFixed = new LinkedHashMap<>();
         for (Map.Entry<?, ?> entry: ((Map<?, ?>) arg).entrySet()) {
            String key = (String) entry.getKey();
            Object val = entry.getValue();
            List<Object> newPathToItem = new ArrayList<>(pathToItem);
            newPathToItem.add(key);
            Object fixedVal = castToAllowedTypes(val, newPathToItem, pathSet);
            argFixed.put(key, fixedVal);
         }
         return new FrozenMap<>(argFixed);
      } else if (arg instanceof Boolean) {
         pathSet.add(pathToItem);
         return arg;
      } else if (arg instanceof Integer) {
         pathSet.add(pathToItem);
         return arg;
      } else if (arg instanceof Long) {
         pathSet.add(pathToItem);
         return arg;
      } else if (arg instanceof Float) {
         pathSet.add(pathToItem);
         return arg;
      } else if (arg instanceof Double) {
         pathSet.add(pathToItem);
         return arg;
      } else if (arg instanceof List) {
         pathSet.add(pathToItem);
         List<Object> argFixed = new ArrayList<>();
         int i =0;
         for (Object item: ((List<?>) arg).toArray()) {
            List<Object> newPathToItem = new ArrayList<>(pathToItem);
            newPathToItem.add(i);
            Object fixedVal = castToAllowedTypes(item, newPathToItem, pathSet);
            argFixed.add(fixedVal);
            i += 1;
         }
         return new FrozenList<>(argFixed);
      } else if (arg instanceof ZonedDateTime) {
         pathSet.add(pathToItem);
         return arg.toString();
      } else if (arg instanceof LocalDate) {
         pathSet.add(pathToItem);
         return arg.toString();
      } else if (arg instanceof UUID) {
         pathSet.add(pathToItem);
         return arg.toString();
      } else {
         Class<?> argClass = arg.getClass();
         throw new InvalidTypeException("Invalid type passed in for input="+arg+" type="+argClass);
      }
   }

   private static PathToSchemasMap getPathToSchemas(Class<? extends JsonSchema> cls, Object arg, ValidationMetadata validationMetadata, Set<List<Object>> pathSet) {
      PathToSchemasMap pathToSchemasMap = new PathToSchemasMap();
      if (validationMetadata.validationRanEarlier(cls)) {
         // todo add deeper validated schemas
      } else {
         PathToSchemasMap otherPathToSchemas = validate(cls, arg, validationMetadata);
         pathToSchemasMap.update(otherPathToSchemas);
         for (LinkedHashMap<Class<? extends JsonSchema>, Void> schemas: pathToSchemasMap.values()) {
            Class<? extends JsonSchema> firstSchema = schemas.entrySet().iterator().next().getKey();
            schemas.clear();
            schemas.put(firstSchema, null);
         }
         pathSet.removeAll(pathToSchemasMap.keySet());
         if (!pathSet.isEmpty()) {
            LinkedHashMap<Class<? extends JsonSchema>, Void> unsetAnyTypeSchema = new LinkedHashMap<>();
            unsetAnyTypeSchema.put(UnsetAnyTypeJsonSchema.class, null);
            for (List<Object> pathToItem: pathSet) {
               pathToSchemasMap.put(pathToItem, unsetAnyTypeSchema);
            }
         }
      }
      return pathToSchemasMap;
   }

   private static FrozenMap<String, Object> getProperties(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
      LinkedHashMap<String, Object> properties = new LinkedHashMap<>();
      for(Map.Entry<?, ?> entry: arg.entrySet()) {
         String propertyName = (String) entry.getKey();
         List<Object> propertyPathToItem = new ArrayList<>(pathToItem);
         propertyPathToItem.add(propertyName);
         Class<? extends JsonSchema> propertyClass = pathToSchemas.get(propertyPathToItem).entrySet().iterator().next().getKey();
         Object value = entry.getValue();
         Object castValue = getNewInstance(propertyClass, value, propertyPathToItem, pathToSchemas);
         properties.put(propertyName, castValue);
      }
      return new FrozenMap<>(properties);
   }

   private static FrozenList<Object> getItems(List<?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
      ArrayList<Object> items = new ArrayList<>();
      int i = 0;
      for (Object item: arg) {
         List<Object> itemPathToItem = new ArrayList<>(pathToItem);
         itemPathToItem.add(i);
         Class<? extends JsonSchema> itemClass = pathToSchemas.get(itemPathToItem).entrySet().iterator().next().getKey();
         Object castItem = getNewInstance(itemClass, item, itemPathToItem, pathToSchemas);
         items.add(castItem);
         i += 1;
      }
      return new FrozenList<>(items);
   }

   private static Object getNewInstance(Class<? extends JsonSchema> cls, Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
      if (arg instanceof Map) {
         FrozenMap<String, Object> usedArg = getProperties((Map<?,?>) arg, pathToItem, pathToSchemas);
         try {
            Method method = cls.getDeclaredMethod("getMapOutputInstance", FrozenMap.class);
            // needed because this is a protected method, but it is across packages
            method.setAccessible(true);
            return method.invoke(null, usedArg);
         } catch (NoSuchMethodException e) {
            return usedArg;
         } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
         }
      } else if (arg instanceof List) {
         FrozenList<Object> usedArg = getItems((List<?>) arg, pathToItem, pathToSchemas);
         try {
            Method method = cls.getDeclaredMethod("getListOutputInstance", FrozenList.class);
            // needed because this is a protected method, but it is across packages
            method.setAccessible(true);
            return method.invoke(null, usedArg);
         } catch (NoSuchMethodException e) {
            return usedArg;
         } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
         }
      }
      // str, int, float, boolean, null, FileIO, bytes
      return arg;
   }

   protected static Void validateVoid(Class<? extends JsonSchema> cls, Void arg, SchemaConfiguration configuration) throws ValidationException {
      return (Void) validate(cls, arg, configuration);
   }

   protected static boolean validateBoolean(Class<? extends JsonSchema> cls, boolean arg, SchemaConfiguration configuration) throws ValidationException {
      return (boolean) validate(cls, arg, configuration);
   }

   protected static int validateInt(Class<? extends JsonSchema> cls, int arg, SchemaConfiguration configuration) throws ValidationException {
      return (int) validate(cls, arg, configuration);
   }

   protected static long validateLong(Class<? extends JsonSchema> cls, long arg, SchemaConfiguration configuration) throws ValidationException {
      return (long) validate(cls, arg, configuration);
   }

   protected static float validateFloat(Class<? extends JsonSchema> cls, float arg, SchemaConfiguration configuration) throws ValidationException {
      return (float) validate(cls, arg, configuration);
   }

   protected static double validateDouble(Class<? extends JsonSchema> cls, double arg, SchemaConfiguration configuration) throws ValidationException {
      return (double) validate(cls, arg, configuration);
   }

   protected static String validateString(Class<? extends JsonSchema> cls, String arg, SchemaConfiguration configuration) throws ValidationException {
      return (String) validate(cls, arg, configuration);
   }

   protected static String validateZonedDateTime(Class<? extends JsonSchema> cls, ZonedDateTime arg, SchemaConfiguration configuration) throws ValidationException {
      return (String) validate(cls, arg, configuration);
   }

   protected static String validateLocalDate(Class<? extends JsonSchema> cls, LocalDate arg, SchemaConfiguration configuration) throws ValidationException {
      return (String) validate(cls, arg, configuration);
   }

   protected static String validateUUID(Class<? extends JsonSchema> cls, UUID arg, SchemaConfiguration configuration) throws ValidationException {
      return (String) validate(cls, arg, configuration);
   }

   protected static <T extends FrozenMap> T validateMap(Class<? extends JsonSchema> cls, Map<String, ?> arg, SchemaConfiguration configuration) throws ValidationException {
      return (T) validate(cls, arg, configuration);
   }

   protected static <U extends FrozenList> U validateList(Class<? extends JsonSchema> cls, List<?> arg, SchemaConfiguration configuration) throws ValidationException {
      return (U) validate(cls, arg, configuration);
   }

   // todo add bytes and FileIO

   public static Object validate(Class<? extends JsonSchema> cls, Object arg, SchemaConfiguration configuration) throws ValidationException {
      if (arg instanceof Map || arg instanceof List) {
         // todo don't run validation if the instance is one of the class generic types
      }
      Set<List<Object>> pathSet = new HashSet<>();
      List<Object> pathToItem = new ArrayList<>();
      pathToItem.add("args[0]");
      Object castArg = castToAllowedTypes(arg, pathToItem, pathSet);
      SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(JsonSchemaKeywordFlags.ofNone()));
      PathToSchemasMap validatedPathToSchemas = new PathToSchemasMap();
      ValidationMetadata validationMetadata = new ValidationMetadata(
              pathToItem,
              usedConfiguration,
              validatedPathToSchemas,
              new LinkedHashSet<>()
      );
      PathToSchemasMap pathToSchemasMap = getPathToSchemas(cls, castArg, validationMetadata, pathSet);
      return getNewInstance(cls, castArg, validationMetadata.pathToItem(), pathToSchemasMap);
   }

}