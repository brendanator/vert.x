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
package core.rest

import org.vertx.java.core.http. {HttpServerRequest => JHttpServerRequest}
import org.vertx.java.core.Handler
import org.vertx.java.core.http.HttpServerRequest
import org.vertx.java.core.buffer.Buffer
/**
 * @author (Slim Ouertani)
 */
trait Response extends  Function1 [HttpServerRequest, Any] {
  
}


case class OK[T] (msg :HttpServerRequest => T)(implicit  convertor : T => Buffer) extends  Response {
  def apply(request : HttpServerRequest) {
     request.response.statusCode=200
     request.response.end(msg (request))
  }
}

case class Unauthorized[T] (msg : HttpServerRequest => T) (implicit  convertor : T => Buffer) extends  Function1 [HttpServerRequest, Unit] {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=401
    request.response.end(msg (request))
  }
}












/*
case class Continue (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=100
    request.response.end(msg)
  }
}
case class SwitchingProtocols (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=101
    request.response.end(msg)
  }
}
case class Processing (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=102
    request.response.end(msg)
  }
}

case class Created (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=201
    request.response.end(msg)
  }
}
case class Accepted (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=202
    request.response.end(msg)
  }
}
case class NonAuthoritativeInformation (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=203
    request.response.end(msg)
  }
}
case class NoContent (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=204
    request.response.end(msg)
  }
}
case class ResetContent (msg : String) extends Response  {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=205
    request.response.end(msg)
  }
}
case class PartialContent (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=206
    request.response.end(msg)
  }
}
case class MultiStatus (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=207
    request.response.end(msg)
  }
}
case class AlreadyReported (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=208
    request.response.end(msg)
  }
}
case class IMUsed (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=226
    request.response.end(msg)
  }
}

case class MultipleChoices (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=300
    request.response.end(msg)
  }
}
case class MovedPermanently (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=301
    request.response.end(msg)
  }
}
case class Found (msg : String) extends Response  
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=302
    request.response.end(msg)
  }
}
case class SeeOther (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=303
    request.response.end(msg)
  }
}
case class NotModified (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=304
    request.response.end(msg)
  }
}
case class UseProxy (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=305
    request.response.end(msg)
  }
}
case class TemporaryRedirect (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=307
    request.response.end(msg)
  }
}

case class BadRequest (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=400
    request.response.end(msg)
  }
}
case class Unauthorized (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=401
    request.response.end(msg)
  }
}
case class PaymentRequired (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=402
    request.response.end(msg)
  }
}
case class Forbidden (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=403
    request.response.end(msg)
  }
}
case class NotFound (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=404
    request.response.end(msg)
  }
}
case class MethodNotAllowed (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=405
    request.response.end(msg)
  }
}
case class NotAcceptable (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=406
    request.response.end(msg)
  }
}
case class ProxyAuthenticationRequired (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=407
    request.response.end(msg)
  }
}
case class RequestTimeout (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=408
    request.response.end(msg)
  }
}
case class Conflict (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=409
    request.response.end(msg)
  }
}
case class Gone (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=410
    request.response.end(msg)
  }
}
case class LengthRequired (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=411
    request.response.end(msg)
  }
}
case class PreconditionFailed (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=412
    request.response.end(msg)
  }
}
case class RequestEntityTooLarge (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=413
    request.response.end(msg)
  }
}
case class RequestURITooLong (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=414
    request.response.end(msg)
  }
}
case class UnsupportedMediaType (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=415
    request.response.end(msg)
  }
}
case class RequestedRangeNotSatisfiable (msg : String) extends Response  {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=416
    request.response.end(msg)
  }
}
case class ExpectationFailed (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=417
    request.response.end(msg)
  }
}
case class TeaPot (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=418
    request.response.end(msg)
  }
}
case class TooManyConnections (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=421
    request.response.end(msg)
  }
}
case class UnprocessableEntity (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=422
    request.response.end(msg)
  }
}
case class Locked (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=423
    request.response.end(msg)
  }
}
case class FailedDependency (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=424
    request.response.end(msg)
  }
}
case class UnorderedCollection (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=425
    request.response.end(msg)
  }
}
case class UpdateRequired (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=426
    request.response.end(msg)
  }
}
case class PreconditionRequired (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=428
    request.response.end(msg)
  }
}
case class TooManyRequests (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=429
    request.response.end(msg)
  }
}
case class RequestHeaderFieldsTooLarge (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=431
    request.response.end(msg)
  }
}

case class InternalServerError (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=500
    request.response.end(msg)
  }
}
case class NotImplemented (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=501
    request.response.end(msg)
  }
}
case class BadGateway (msg : String) extends Response {
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=502
    request.response.end(msg)
  }
}
case class ServiceUnavailable (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=503
    request.response.end(msg)
  }
}
case class GatewayTimeout (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=504
    request.response.end(msg)
  }
}
case class VersionNotSupported (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=505
    request.response.end(msg)
  }
}
case class VariantAlsoNegotiates (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=506
    request.response.end(msg)
  }
}
case class InsufficientStorage (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=507
    request.response.end(msg)
  }
}
case class LoopDetected (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=508
    request.response.end(msg)
  }
}
case class NotExtended (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=510
    request.response.end(msg)
  }
}
case class NetworkAuthenticationRequired (msg : String) extends Response 
{
  def apply(request : JHttpServerRequest) {
    request.response.statusCode=511
    request.response.end(msg)
  }
}

*/