package main.intermediate

sealed class Request

class UnathenticatedRequest : Request()
class AuthenticatedRequest : Request()
class VerifiedWithBankIdRequest : Request()
class AuthorizedRequest : Request()

fun UnathenticatedRequest.authenticate() = AuthenticatedRequest()
fun AuthenticatedRequest.verify() = VerifiedWithBankIdRequest()
fun VerifiedWithBankIdRequest.authorize() = AuthorizedRequest()

fun main() {
  val authorizedRequest =
    UnathenticatedRequest()
      .authenticate()
      .verify()
      .authorize()
}
