# coding: utf-8

"""
    Generated by: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
"""

from petstore_api.paths.user_login.get.operation import LoginUser
from petstore_api.paths.user_logout.get.operation import LogoutUser
from petstore_api.paths.user_username.delete.operation import DeleteUser
from petstore_api.paths.user_username.get.operation import GetUserByName
from petstore_api.paths.user_username.put.operation import UpdateUser
from petstore_api.paths.user_create_with_array.post.operation import CreateUsersWithArrayInput
from petstore_api.paths.user_create_with_list.post.operation import CreateUsersWithListInput
from petstore_api.paths.user.post.operation import CreateUser


class UserApi(
    LoginUser,
    LogoutUser,
    DeleteUser,
    GetUserByName,
    UpdateUser,
    CreateUsersWithArrayInput,
    CreateUsersWithListInput,
    CreateUser,
):
    """NOTE: This class is auto generated by OpenAPI JSON Schema Generator
    Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator

    Do not edit the class manually.
    """
    pass
