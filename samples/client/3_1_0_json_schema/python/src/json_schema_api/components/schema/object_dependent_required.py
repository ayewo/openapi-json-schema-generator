# coding: utf-8

"""
    Example
    No description provided (generated by Openapi JSON Schema Generator https://github.com/openapi-json-schema-tools/openapi-json-schema-generator)  # noqa: E501
    The version of the OpenAPI document: 1.0.0
    Generated by: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
"""

from __future__ import annotations
from json_schema_api.shared_imports.schema_imports import *  # pyright: ignore [reportWildcardImportFromLibrary]



@dataclasses.dataclass(frozen=True)
class ObjectDependentRequired(
    schemas.Schema[schemas.immutabledict[str, schemas.OUTPUT_BASE_TYPES], tuple]
):
    """NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
    Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator

    Do not edit the class manually.
    """
    types: typing.FrozenSet[typing.Type] = frozenset({schemas.immutabledict})
    dependent_required: typing.Mapping[str, typing.Set[str]] = dataclasses.field(
        default_factory=lambda: {
            "a": {
                "b",
            },
        }
    )
    @classmethod
    def validate(
        cls,
        arg: typing.Mapping[str, schemas.INPUT_TYPES_ALL],
        configuration: typing.Optional[schema_configuration.SchemaConfiguration] = None
    ) -> schemas.immutabledict[str, schemas.OUTPUT_BASE_TYPES]:
        return super().validate_base(
            arg,
            configuration=configuration,
        )

