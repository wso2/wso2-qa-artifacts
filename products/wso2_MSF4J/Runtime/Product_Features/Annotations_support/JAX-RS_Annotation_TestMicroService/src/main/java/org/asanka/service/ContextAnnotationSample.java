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
import javax.ws.rs.core.Context;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.msf4j.HttpResponder;
import org.wso2.msf4j.HttpStreamHandler;
import org.wso2.msf4j.HttpStreamer;

import java.io.*;
import java.nio.file.Paths;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 1.0.0
 */
@Path("/Context")
public class ContextAnnotationSample {

    public static final String MOUNT_PATH = "/var/www/html/upload";
    public static final Logger log = LoggerFactory.getLogger(ContextAnnotationSample.class);


    @GET
    @Path("HttpRequest")
    public String getHttpRequest(@Context HttpRequest request) {

        System.out.println(request.getUri());
        return request.getUri();
    }

    @GET
    @Path("HttpResponder")
    public String getHttpResponder(@Context HttpResponder responder) {


        System.out.println(responder.toString());
        return responder.toString();

    }
}