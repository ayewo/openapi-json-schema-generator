# Schema
petstore_api.paths.pet_pet_id_upload_image.post.request_body.content.multipart_form_data.schema
```
type: schemas.Schema
```

## validate method
Input Type | Return Type | Notes
------------ | ------------- | -------------
[SchemaDictInput](#schemadictinput), [SchemaDict](#schemadict) | [SchemaDict](#schemadict) |

## SchemaDictInput
```
type: typing.Mapping[str, schemas.INPUT_TYPES_ALL]
```
Key | Type |  Description | Notes
------------ | ------------- | ------------- | -------------
**additionalMetadata** | str | Additional data to pass to server | [optional]
**file** | bytes, io.FileIO, io.BufferedReader | file to upload | [optional]
**any_string_name** | dict, schemas.immutabledict, list, tuple, decimal.Decimal, float, int, str, datetime.date, datetime.datetime, uuid.UUID, bool, None, bytes, io.FileIO, io.BufferedReader, schemas.FileIO | any string name can be used but the value must be the correct type | [optional]

## SchemaDict
```
base class: schemas.immutabledict[str, schemas.OUTPUT_BASE_TYPES]

```
### &lowbar;&lowbar;new&lowbar;&lowbar; method
Keyword Argument | Type | Description | Notes
---------------- | ---- | ----------- | -----
**additionalMetadata** | str, schemas.Unset | Additional data to pass to server | [optional]
**file** | bytes, io.FileIO, io.BufferedReader, schemas.Unset | file to upload | [optional]
**kwargs** | schemas.immutabledict, tuple, float, int, str, bool, None, bytes, schemas.FileIO | any string name can be used but the value must be the correct type | [optional] typed value is accessed with the get_additional_property_ method

### properties
Property | Type | Description | Notes
-------- | ---- | ----------- | -----
**additionalMetadata** | str, schemas.Unset | Additional data to pass to server | [optional]
**file** | bytes, io.FileIO, schemas.Unset | file to upload | [optional]

### methods
Method | Input Type | Return Type | Notes
------ | ---------- | ----------- | ------
from_dict_ | [SchemaDictInput](#schemadictinput), [SchemaDict](#schemadict) | [SchemaDict](#schemadict) | a constructor
get_additional_property_ | str | schemas.immutabledict, tuple, float, int, str, bool, None, bytes, schemas.FileIO, schemas.Unset | provides type safety for additional properties
