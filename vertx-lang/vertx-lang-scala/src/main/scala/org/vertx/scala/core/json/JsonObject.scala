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
package org.vertx.scala.core
package json

import org.vertx.java.core.json.{JsonObject => JJsonObject}
import org.vertx.java.core.buffer.Buffer
/**
 * @author (Slim Ouertani)
 */
case class JsonObject (jObject : JJsonObject =  new JJsonObject() ){
  def withString (elem : ( String, String ))= {jObject.putString(elem._1, elem._2); this}
  
}
object JsonObject {
  def withString (elem : ( String, String ))= {
    val obj = JsonObject();
    obj.jObject.putString(elem._1, elem._2); obj}
  implicit def toBuffer (json : JsonObject) : Buffer = json.jObject.encode
}


