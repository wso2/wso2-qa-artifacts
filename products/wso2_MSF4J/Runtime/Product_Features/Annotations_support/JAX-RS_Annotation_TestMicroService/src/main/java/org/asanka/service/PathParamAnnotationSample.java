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
import java.util.Date;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 1.0.0
 */
@Path("/PathParam")
public class PathParamAnnotationSample {

    @GET
    @Path("user/{id}")
    public String getUser(@PathParam("id") String id) {


        System.out.println("Your User ID Is::::::::::"+id);
        return "Your User ID Is::::::::::"+id;
    }

    @GET
    @Path("user/{id}/{name}/{salary}/{bday}")
    public String getUserDetails(@PathParam("id") String id, @PathParam("name") String name, @PathParam("salary") int salary, @PathParam("bday")Date bday) {


        System.out.println(":::::::::::::User Details::::::::::");
        System.out.println("Username::"+name+"::::::UserID:::::"+id+"::::Salary::::"+salary+":::B'Day:::::"+bday);

        return ":::::::::::::User Details::::::::::"+"Username::"+name+"::::::UserID:::::"+id+"::::Salary::::"+salary+":::B'Day:::::"+bday;


    }
}
