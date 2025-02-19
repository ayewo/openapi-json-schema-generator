# coding: utf-8

"""
    OpenAPI Petstore
    This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: " \  # noqa: E501
    The version of the OpenAPI document: 1.0.0
    Generated by: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
"""

from __future__ import annotations
from petstore_api.shared_imports.schema_imports import *  # pyright: ignore [reportWildcardImportFromLibrary]

AdditionalProperties: typing_extensions.TypeAlias = schemas.NotAnyTypeSchema

from petstore_api.paths.fake.delete.parameters.parameter_0 import schema
from petstore_api.paths.fake.delete.parameters.parameter_2 import schema as schema_4
from petstore_api.paths.fake.delete.parameters.parameter_3 import schema as schema_3
from petstore_api.paths.fake.delete.parameters.parameter_5 import schema as schema_2
Properties = typing.TypedDict(
    'Properties',
    {
        "required_string_group": typing.Type[schema.Schema],
        "int64_group": typing.Type[schema_2.Schema],
        "string_group": typing.Type[schema_3.Schema],
        "required_int64_group": typing.Type[schema_4.Schema],
    }
)
QueryParametersRequiredDictInput = typing.TypedDict(
    'QueryParametersRequiredDictInput',
    {
        "required_int64_group": int,
        "required_string_group": str,
    }
)
QueryParametersOptionalDictInput = typing.TypedDict(
    'QueryParametersOptionalDictInput',
    {
        "int64_group": int,
        "string_group": str,
    },
    total=False
)


class QueryParametersDict(schemas.immutabledict[str, schemas.OUTPUT_BASE_TYPES]):

    __required_keys__: typing.FrozenSet[str] = frozenset({
        "required_int64_group",
        "required_string_group",
    })
    __optional_keys__: typing.FrozenSet[str] = frozenset({
        "int64_group",
        "string_group",
    })
    
    def __new__(
        cls,
        *,
        required_int64_group: int,
        required_string_group: str,
        int64_group: typing.Union[
            int,
            schemas.Unset
        ] = schemas.unset,
        string_group: typing.Union[
            str,
            schemas.Unset
        ] = schemas.unset,
        configuration_: typing.Optional[schema_configuration.SchemaConfiguration] = None,
    ):
        arg_: typing.Dict[str, typing.Any] = {
            "required_int64_group": required_int64_group,
            "required_string_group": required_string_group,
        }
        for key_, val in (
            ("int64_group", int64_group),
            ("string_group", string_group),
        ):
            if isinstance(val, schemas.Unset):
                continue
            arg_[key_] = val
        used_arg_ = typing.cast(QueryParametersDictInput, arg_)
        return QueryParameters.validate(used_arg_, configuration=configuration_)
    
    @staticmethod
    def from_dict_(
        arg: typing.Union[
            QueryParametersDictInput,
            QueryParametersDict
        ],
        configuration: typing.Optional[schema_configuration.SchemaConfiguration] = None
    ) -> QueryParametersDict:
        return QueryParameters.validate(arg, configuration=configuration)
    
    @property
    def required_int64_group(self) -> int:
        return typing.cast(
            int,
            self.__getitem__("required_int64_group")
        )
    
    @property
    def required_string_group(self) -> str:
        return typing.cast(
            str,
            self.__getitem__("required_string_group")
        )
    
    @property
    def int64_group(self) -> typing.Union[int, schemas.Unset]:
        val = self.get("int64_group", schemas.unset)
        if isinstance(val, schemas.Unset):
            return val
        return typing.cast(
            int,
            val
        )
    
    @property
    def string_group(self) -> typing.Union[str, schemas.Unset]:
        val = self.get("string_group", schemas.unset)
        if isinstance(val, schemas.Unset):
            return val
        return typing.cast(
            str,
            val
        )


class QueryParametersDictInput(QueryParametersRequiredDictInput, QueryParametersOptionalDictInput):
    pass


@dataclasses.dataclass(frozen=True)
class QueryParameters(
    schemas.Schema[QueryParametersDict, tuple]
):
    types: typing.FrozenSet[typing.Type] = frozenset({schemas.immutabledict})
    required: typing.FrozenSet[str] = frozenset({
        "required_int64_group",
        "required_string_group",
    })
    properties: Properties = dataclasses.field(default_factory=lambda: schemas.typed_dict_to_instance(Properties)) # type: ignore
    additional_properties: typing.Type[AdditionalProperties] = dataclasses.field(default_factory=lambda: AdditionalProperties) # type: ignore
    type_to_output_cls: typing.Mapping[
        typing.Type,
        typing.Type
    ] = dataclasses.field(
        default_factory=lambda: {
            schemas.immutabledict: QueryParametersDict
        }
    )

    @classmethod
    def validate(
        cls,
        arg: typing.Union[
            QueryParametersDictInput,
            QueryParametersDict,
        ],
        configuration: typing.Optional[schema_configuration.SchemaConfiguration] = None
    ) -> QueryParametersDict:
        return super().validate_base(
            arg,
            configuration=configuration,
        )

