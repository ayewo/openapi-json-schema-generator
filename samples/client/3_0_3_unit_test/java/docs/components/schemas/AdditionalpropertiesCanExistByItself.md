# AdditionalpropertiesCanExistByItself
org.openapijsonschematools.client.components.schemas.AdditionalpropertiesCanExistByItself.java
public class AdditionalpropertiesCanExistByItself

A class that contains necessary nested schema classes, and classes to store validated list and map payloads

## Nested Class Summary
| Modifier and Type | Class and Description |
| ----------------- | ---------------------- |
| static class | [AdditionalpropertiesCanExistByItself.AdditionalpropertiesCanExistByItself1](#additionalpropertiescanexistbyitself1)<br> schema class |
| static class | [AdditionalpropertiesCanExistByItself.AdditionalpropertiesCanExistByItselfMap](#additionalpropertiescanexistbyitselfmap)<br> output class for Map payloads |
| static class | [AdditionalpropertiesCanExistByItself.AdditionalProperties](#additionalproperties)<br> schema class |

## AdditionalpropertiesCanExistByItself1
public static class AdditionalpropertiesCanExistByItself1<br>
extends JsonSchema

A schema class that validates payloads
### Field Summary
| Modifier and Type | Field and Description |
| ----------------- | ---------------------- |
| static LinkedHashMap<String, KeywordValidator> |keywordToValidator<br/>new LinkedHashMap<>(Map.ofEntries(<br/>&nbsp;&nbsp;&nbsp;&nbsp;new KeywordEntry("type", new TypeValidator(Set.of(FrozenMap.class))),<br/>&nbsp;&nbsp;&nbsp;&nbsp;new KeywordEntry("additionalProperties", new AdditionalPropertiesValidator([AdditionalProperties.class](#additionalproperties)))<br>)); |

### Method Summary
| Modifier and Type | Method and Description |
| ----------------- | ---------------------- |
| static [AdditionalpropertiesCanExistByItselfMap](#additionalpropertiescanexistbyitselfmap) | validate(Map<String, Boolean> arg, SchemaConfiguration configuration) |

## AdditionalpropertiesCanExistByItselfMap
public static class AdditionalpropertiesCanExistByItselfMap<br>
extends FrozenMap<String, Boolean>

A class to store validated Map payloads

### Method Summary
| Modifier and Type | Method and Description |
| ----------------- | ---------------------- |
| static [AdditionalpropertiesCanExistByItselfMap](#additionalpropertiescanexistbyitselfmap) | of(Map<String, Boolean> arg, SchemaConfiguration configuration) |
| boolean | getAdditionalProperty(String name)<br>provides type safety for additional properties |

## Input Map Keys
```
type: Map<String, Object>
```
| Key | Type |  Description | Notes |
| --- | ---- | ------------ | ----- |
| **anyStringName** | boolean | any string name can be used but the value must be the correct type | [optional] |

## AdditionalProperties
public static class AdditionalProperties<br>
extends BooleanJsonSchema

A schema class that validates payloads

| Methods Inherited from class org.openapijsonschematools.client.schemas.BooleanJsonSchema |
| ------------------------------------------------------------------ |
| validate                                                           |

[[Back to top]](#top) [[Back to Component Schemas]](../../../README.md#Component-Schemas) [[Back to README]](../../../README.md)
