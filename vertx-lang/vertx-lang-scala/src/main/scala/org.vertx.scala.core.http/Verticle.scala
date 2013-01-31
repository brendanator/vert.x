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

import org.vertx.java.deploy.{Verticle => JVerticle}
import org.vertx.java.core.{Handler =>JHandler }
/**
 * author (Slim Ouertani)
 */
case class Verticle(onStart: JVerticle => Any = _ => ())(onStop: JVerticle => Any = _ => ()) extends JVerticle {
  override def start() {
    onStart(this)
  }

  override def stop() {
    onStop(this)
  }
  implicit def asHandler[T] (h  : T => Any)  : JHandler[T] = new JHandler[T]() {
      override def handle(  e : T) {
        h (e)
      }
   }
}
