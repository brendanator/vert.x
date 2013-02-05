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
package http



import org.vertx.java.core.http.{HttpClientResponse => JHttpClientResponse }

import org.vertx.java.core.http.{HttpClient => JHttpClient}
import org.vertx.java.deploy.Verticle
/**
 * author (Slim Ouertani)
 */
case class HttpClient(client : JHttpClient) (implicit verticle : Option[Verticle]=None)  {
  def andGetNow (path:String)(h:JHttpClientResponse => Any) = {
    client.getNow(path, h)
  }
}
