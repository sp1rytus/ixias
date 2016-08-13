/*
 * This file is part of the IxiaS services.
 *
 * For the full copyright and license information,
 * please view the LICENSE file that was distributed with this source code.
 */

package ixias.play.api.auth.mvc

import javax.inject.{ Inject, Singleton }
import play.api.Environment
import ixias.play.api.auth.token.TokenViaCookie

@Singleton
abstract class AuthProfileViaCookie @Inject() (
  implicit val env: Environment
) extends AuthProfile {

  /** The cookie name */
  val cookieName: String = "sid"

  /** Expiry and Max-Age for cookies */
  val cookieMaxAge: Option[Int] = Some(24 * 3600 * 14) // 2weeks

  /** The accessor for security token. */
  override lazy val tokenAccessor = TokenViaCookie(cookieName, cookieMaxAge)
}