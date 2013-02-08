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
package core.http


import deploy.Verticle
import org.vertx.java.core.http. {HttpServerRequest => JHttpServerRequest, RouteMatcher =>JRouteMatcher}
import org.vertx.scala.core.Handler
import scala.util.matching.Regex
import org.vertx.scala.core.rest._
/**
 * @author (Slim Ouertani)
 */
case class RouteMatcher(jMatcher : JRouteMatcher = new JRouteMatcher())(implicit verticle : Option[Verticle]=None)   {
  def withGet ( pattern: String) (handler : Handler[JHttpServerRequest]):RouteMatcher =  {jMatcher.get(pattern, handler);this}
  def withPost( pattern: String) (handler : Handler[JHttpServerRequest]) : RouteMatcher = {jMatcher.post(pattern, handler);this}
  def withPut ( pattern: String) (handler : Handler[JHttpServerRequest]) : RouteMatcher = {jMatcher.put(pattern, handler);this}
  def withDelete ( pattern: String) (handler : Handler[JHttpServerRequest]) : RouteMatcher = {jMatcher.delete(pattern, handler);this}
  def withHead ( pattern: String) (handler : Handler[JHttpServerRequest]) : RouteMatcher = {jMatcher.head(pattern, handler);this}
  def withAll ( pattern: String) (handler : Handler[JHttpServerRequest]) : RouteMatcher = {jMatcher.all(pattern, handler);this}
  def withAction (action : Action) (handler : Handler[JHttpServerRequest]) : RouteMatcher = action match {
    case GET (p) => withGet(p)(handler)
    case POST (p) => withPost(p)(handler)
    case PUT (p) => withPut(p)(handler)
    case DELETE (p) => withDelete(p)(handler)
    case HEAD (p) => withHead(p)(handler)
    case ALL (p) => withAll(p)(handler)
  }
}
