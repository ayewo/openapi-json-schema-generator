# coding: utf-8

"""
    OpenAPI Petstore
    This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: " \  # noqa: E501
    The version of the OpenAPI document: 1.0.0
    Generated by: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
"""

from __future__ import annotations
from petstore_api.shared_imports.schema_imports import *  # pyright: ignore [reportWildcardImportFromLibrary]


from petstore_api.components.schema import child_cat
from petstore_api.components.schema import grandparent_animal
AllOf = typing.Tuple[
    typing.Type[grandparent_animal.GrandparentAnimal],
]


@dataclasses.dataclass(frozen=True)
class ParentPet(
    schemas.Schema[schemas.immutabledict[str, schemas.OUTPUT_BASE_TYPES], tuple]
):
    """NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
    Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator

    Do not edit the class manually.
    """
    types: typing.FrozenSet[typing.Type] = frozenset({schemas.immutabledict})
    discriminator: typing.Mapping[str, typing.Mapping[str, typing.Type[schemas.Schema]]] = dataclasses.field(
        default_factory=lambda: {
            'pet_type': {
                'ChildCat': child_cat.ChildCat,
            }
        }
    )
    all_of: AllOf = dataclasses.field(default_factory=lambda: schemas.tuple_to_instance(AllOf)) # type: ignore

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

