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
package deploy

import core.rest._
import core.Handler
import org.vertx.java.deploy. {Verticle => JVerticle }
import scala.util.matching.Regex
import org.vertx.scala.core.http.RouteMatcher 
import org.vertx.java.core.http. {HttpServerRequest => JHttpServerRequest, RouteMatcher =>JRouteMatcher}
/**
 * @author (Slim Ouertani)
 */
case class Resticle(port : Int = 8080, host : String = "localhost")  extends JVerticle{

 override def start() {
   def onStarting ( handles : Seq[(Action ,Handler[JHttpServerRequest])]) : RouteMatcher= {
  handles.foldLeft(RouteMatcher()) ( (m,h) => m.withAction(h._1)(h._2))
  }
  vertx.createHttpServer().requestHandler(onStarting (handles)).listen(port, host)
}

def handles : List[(Action ,Handler[JHttpServerRequest])]  = Nil
}

