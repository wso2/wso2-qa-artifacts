/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.asanka.service;

import javax.ws.rs.*;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 1.0.0
 */
@Path("/Path")
public class PathAnnotationSample {

    @GET
    @Path("/")
    public String get() {

        System.out.println("GET invoked");
        return "Hello @PATH works on WSO2 MSF4J";
    }

    @GET
    @Path("users/{username}")
    public String getUser(@PathParam("username") String userName) {

        System.out.println(userName);
        return "Hello::::::::::"+userName;
    }




}
