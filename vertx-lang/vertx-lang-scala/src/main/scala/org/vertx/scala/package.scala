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


import core.http.{HttpClient,HttpServer, HttpServerRequest, RouteMatcher}
import core.Handler
import core.buffer.Encoding
import core.rest.Action
import deploy.Verticle
import core.json.JsonObject 
import core.eventBus.{EventBus, MessageSender}
import org.vertx.java.core.{AsyncResult, AsyncResultHandler}
import org.vertx.java.core.eventbus.{EventBus => JEventBus }
import org.vertx.java.core.buffer.Buffer
import org.vertx.java.core.http.{  ServerWebSocket}
import org.vertx.java.core.{AsyncResult, AsyncResultHandler, Handler => JHandler}
import org.vertx.java.core.logging. {Logger=>JLogger}

import org.vertx.java.core.http.{HttpClient => JHttpClient,
                                 HttpServer => JHttpServer,
                                 HttpServerRequest => JHttpServerRequest,
                                 RouteMatcher =>JRouteMatcher }
import org.vertx.java.deploy.{Verticle => JVerticle}
import org.vertx.java.core.json.{JsonObject => JJsonObject}

import scala.util.matching.Regex

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
  implicit def toHandler[T](matcher : RouteMatcher):JHandler[JHttpServerRequest] = matcher.jMatcher
  
 
  implicit def toClient(client: JHttpClient)(implicit verticle : Option[JVerticle]=None) : HttpClient = HttpClient(client)
  implicit def toServer(server : JHttpServer)(implicit verticle : Option[JVerticle]=None) : HttpServer = HttpServer(server)
  implicit def toEventBus(eventBus : JEventBus) : EventBus =   EventBus(eventBus)
  implicit def toHttpServerRequest(request : JHttpServerRequest) : HttpServerRequest =  HttpServerRequest(request)
  implicit def toRouteMatcher(routeMatcher : JRouteMatcher) : RouteMatcher = RouteMatcher(routeMatcher)
  implicit def toJsonObject(jObject : JJsonObject) : JsonObject = JsonObject(jObject)
  
  implicit def fromVerticleToEventBus(verticle: JVerticle) : EventBus = verticle.getVertx.eventBus
  implicit def fromVerticleToLogger(verticle: JVerticle) :JLogger  = verticle.getContainer.getLogger
  
  implicit def toMessageSender[T] (h : T => Any) :MessageSender [T]= MessageSender(h)

  implicit def toStringConvertor(msg : String )(implicit enc:Encoding= Encoding( "UTF-8")) :Buffer =new Buffer(msg,enc.enc)
 
  
  
  
  
  
  
  
  
}
