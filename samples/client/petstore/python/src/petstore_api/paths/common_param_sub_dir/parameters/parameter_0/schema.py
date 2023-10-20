# coding: utf-8

"""
    OpenAPI Petstore
    This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\  # noqa: E501
    The version of the OpenAPI document: 1.0.0
    Generated by: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
"""

from __future__ import annotations
from petstore_api.shared_imports.schema_imports import *  # pyright: ignore [reportWildcardImportFromLibrary]



class SchemaEnums:

    @schemas.classproperty
    def A(cls) -> typing.Literal["a"]:
        return Schema.validate("a")

    @schemas.classproperty
    def B(cls) -> typing.Literal["b"]:
        return Schema.validate("b")


@dataclasses.dataclass(frozen=True)
class Schema(
    schemas.Schema
):
    types: typing.FrozenSet[typing.Type] = frozenset({
        str,
    })
    enum_value_to_name: typing.Mapping[typing.Union[int, float, str, schemas.Bool, None], str] = dataclasses.field(
        default_factory=lambda: {
            "a": "A",
            "b": "B",
        }
    )
    enums = SchemaEnums

    @typing.overload
    @classmethod
    def validate(
        cls,
        arg: typing.Literal["a"],
        configuration: typing.Optional[schema_configuration.SchemaConfiguration] = None
    ) -> typing.Literal["a"]: ...
    @typing.overload
    @classmethod
    def validate(
        cls,
        arg: typing.Literal["b"],
        configuration: typing.Optional[schema_configuration.SchemaConfiguration] = None
    ) -> typing.Literal["b"]: ...
    @typing.overload
    @classmethod
    def validate(
        cls,
        arg: str,
        configuration: typing.Optional[schema_configuration.SchemaConfiguration] = None
    ) -> typing.Literal["a","b",]: ...
    @classmethod
    def validate(
        cls,
        arg,
        configuration: typing.Optional[schema_configuration.SchemaConfiguration] = None
    ) -> typing.Literal[
        "a",
        "b",
    ]:
        validated_arg = super().validate_base(
            arg,
            configuration=configuration,
        )
        return typing.cast(typing.Literal[
                "a",
                "b",
            ],
            validated_arg
        )
