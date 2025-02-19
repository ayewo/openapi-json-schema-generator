/*
 * Copyright 2018 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 * Copyright 2018 SmartBear Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapijsonschematools.codegen.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.core.models.AuthorizationValue;

import org.openapijsonschematools.codegen.generators.Generator;
import org.openapijsonschematools.codegen.templating.TemplateDefinition;

import java.util.List;

public class ClientOptInput {
    private Generator config;
    private OpenAPI openAPI;
    private List<AuthorizationValue> auths;
    private List<TemplateDefinition> userDefinedTemplates;

    public ClientOptInput openAPI(OpenAPI openAPI) {
        this.setOpenAPI(openAPI);
        return this;
    }

    public ClientOptInput config(Generator generator) {
        this.setConfig(generator);
        return this;
    }

    public ClientOptInput userDefinedTemplates(List<TemplateDefinition> userDefinedTemplates) {
        this.userDefinedTemplates = userDefinedTemplates;
        return this;
    }

    @Deprecated
    public ClientOptInput auth(String urlEncodedAuthString) {
        this.setAuth(urlEncodedAuthString);
        return this;
    }

    @Deprecated
    public String getAuth() {
        return AuthParser.reconstruct(auths);
    }

    @Deprecated
    public void setAuth(String urlEncodedAuthString) {
        this.auths = AuthParser.parse(urlEncodedAuthString);
    }

    @Deprecated
    public List<AuthorizationValue> getAuthorizationValues() {
        return auths;
    }

    @Deprecated
    public Generator getConfig() {
        return config;
    }

    public List<TemplateDefinition> getUserDefinedTemplates() {
        // not deprecated as this is added to match other functionality, we need to move to Context<?> instead of ClientOptInput.
        return userDefinedTemplates;
    }

    /**
     * Sets the generator/config instance
     *
     * @deprecated use {@link #config(Generator)} instead
     * @param config codegen config
     */
    @Deprecated
    public void setConfig(Generator config) {
        this.config = config;
        // TODO: ClientOptInputs needs to be retired
        if (this.openAPI != null) {
            this.config.setOpenAPI(this.openAPI);
        }
    }

    @Deprecated
    public OpenAPI getOpenAPI() {
        return openAPI;
    }

    /**
     * Sets the OpenAPI document
     *
     * @deprecated use {@link #openAPI(OpenAPI)} instead
     * @param openAPI the specification
     */
    @Deprecated
    public void setOpenAPI(OpenAPI openAPI) {
        this.openAPI = openAPI;
        // TODO: ClientOptInputs needs to be retired
        if (this.config != null) {
            this.config.setOpenAPI(this.openAPI);
        }
    }
}
