# ArrayTypeMatchesArrays
org.openapijsonschematools.client.components.schemas.ArrayTypeMatchesArrays.java
public class ArrayTypeMatchesArrays

A class that contains necessary nested schema classes, and classes to store validated list and map payloads

## Nested Class Summary
| Modifier and Type | Class and Description |
| ----------------- | ---------------------- |
| static class | [ArrayTypeMatchesArrays.ArrayTypeMatchesArrays1](#arraytypematchesarrays1)<br> schema class |
| static class | [ArrayTypeMatchesArrays.ArrayTypeMatchesArraysList](#arraytypematchesarrayslist)<br> output class for List payloads |
| static class | [ArrayTypeMatchesArrays.Items](#items)<br> schema class |

## ArrayTypeMatchesArrays1
public static class ArrayTypeMatchesArrays1<br>
extends JsonSchema

A schema class that validates payloads
### Field Summary
| Modifier and Type | Field and Description |
| ----------------- | ---------------------- |
| static LinkedHashMap<String, KeywordValidator> |keywordToValidator<br/>new LinkedHashMap<>(Map.ofEntries(<br/>&nbsp;&nbsp;&nbsp;&nbsp;new KeywordEntry("type", new TypeValidator(Set.of(FrozenList.class))),<br/>&nbsp;&nbsp;&nbsp;&nbsp;new KeywordEntry("items", new ItemsValidator([Items.class](#items)))<br>)); |

### Method Summary
| Modifier and Type | Method and Description |
| ----------------- | ---------------------- |
| static [ArrayTypeMatchesArraysList](#arraytypematchesarrayslist) | validate(List<Object> arg, SchemaConfiguration configuration) |

## ArrayTypeMatchesArraysList
public class ArrayTypeMatchesArraysList<br>
extends `FrozenList<Object>`

A class to store validated List payloads

### Method Summary
| Modifier and Type | Method and Description |
| ----------------- | ---------------------- |
| static [ArrayTypeMatchesArraysList](#arraytypematchesarrayslist) | of(List<Object> arg, SchemaConfiguration configuration) |

## Input List Items
```
type: List<Object>
```
List Item Type | Description | Notes
-------------------- | ------------- | -------------
Object |  |

## Items
public static class Items<br>
extends AnyTypeJsonSchema

A schema class that validates payloads

| Methods Inherited from class org.openapijsonschematools.client.schemas.AnyTypeJsonSchema |
| ------------------------------------------------------------------ |
| validate                                                           |

[[Back to top]](#top) [[Back to Component Schemas]](../../../README.md#Component-Schemas) [[Back to README]](../../../README.md)
