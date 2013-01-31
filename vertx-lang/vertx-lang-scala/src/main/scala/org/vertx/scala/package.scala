/*
 * Copyright 2011-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vertx.scala 


import core.http.{HttpClient,HttpServer}
import core.Handler
import org.vertx.java.core.{AsyncResult, AsyncResultHandler}
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.http.{ HttpServerRequest, ServerWebSocket}
import org.vertx.java.core.{AsyncResult, AsyncResultHandler, Handler => JHandler}


import org.vertx.java.core.http.{HttpClient => JHttpClient, HttpServer => JHttpServer}
import org.vertx.java.deploy.{Verticle => JVerticle}

/**
 * @author (Slim Ouertani)
 */
package object core {
  implicit def toHandler[T] (h  : T => Any)(implicit verticle:Option[JVerticle]=None)  : Handler[T] = new JHandler[T]() {
    override def handle( e : T) { h (e)}
  }
  implicit def toHandler[T](handler : JHandler[T])(implicit verticle : Option[JVerticle]=None)  : Handler[T]=  new Handler[T] (){
    override def handle( e : T) { handler.handle(e)}
  }
  
 
  implicit def toClient(client: JHttpClient)(implicit verticle : Option[JVerticle]=None) : HttpClient = HttpClient(client)
  implicit def toServer(server : JHttpServer)(implicit verticle : Option[JVerticle]=None) : HttpServer = HttpServer(server)
}
