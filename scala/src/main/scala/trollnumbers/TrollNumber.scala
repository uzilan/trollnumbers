package trollnumbers

import scala.language.implicitConversions

/** Exception that should be thrown if the user uses TrollNumbers that are bigger then what a troll can grasp */
class TrollsDontDoBigNumbersException extends Exception

/** This class allows creating troll numbers, as well as adding them to each other. For example:
  * {{{
  * val two = Two
  * val five = Many-One
  * val fourteen = five + Many-Many-One
  * }}}
  *
  * @param value the numeric value of this [[trollnumbers.TrollNumber]]
  */
class TrollNumber(val value: Int) {

  /** Describes this [[trollnumbers.TrollNumber]] */
  override def toString: String = value match {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
    case 4 => "Many"
    case 16 => "Lots"
  }

  /** Allows joining [[trollnumbers.TrollNumber]]s together, for example:
    * {{{
    * val five = Many-One
    * val eleven = Many-Many-Three
    * }}}
    *
    * @param other the other [[trollnumbers.TrollNumber]] to join with this one
    * @return a new [[trollnumbers.TrollNumber]] with this one combined with the other
    */
  def -(other: TrollNumber): TrollNumber = this + other

  /** Allows adding one [[trollnumbers.TrollNumber]] to another, for example:
    * {{{
    * val three = One + Two
    * val twelve = Many-Many-One + Three
    * }}}
    *
    * @param other the other [[trollnumbers.TrollNumber]] to add to this one
    * @return a new [[trollnumbers.TrollNumber]] with this one added to the other
    */
  def +(other: TrollNumber): TrollNumber = TrollNumber(this.value + other.value)

}

/** Allows creating simple and complex troll numbers, as well as converting `Int`s to
  * [[trollnumbers.TrollNumber]]s and vise verse
  */
object TrollNumber {
  /** Troll number One with value 1 */
  val One = new TrollNumber(1)
  /** Troll number Two with value 2 */
  val Two = new TrollNumber(2)
  /** Troll number Three with value 3 */
  val Three = new TrollNumber(3)
  /** Troll number Many with value 4 */
  val Many = new TrollNumber(4)
  /** Troll number Lots with value 16 */
  val Lots = new TrollNumber(16)

  def apply(i: Int): TrollNumber = int2TrollNumber(i)

  /** Allows converting a [[trollnumbers.TrollNumber]] into an `Int`
    *
    * @param tn the [[trollnumbers.TrollNumber]] to convert
    * @return the [[trollnumbers.TrollNumber]] value as an `Int`
    */
  implicit def TrollNumber2Int(tn: TrollNumber): Int = tn.value

  /** Allows converting an `Int` into a [[trollnumbers.TrollNumber]]
    *
    * @param i the `Int` to convert
    * @return the `Int`'s value as a [[trollnumbers.TrollNumber]]
    */
  implicit def int2TrollNumber(i: Int): TrollNumber = {
    if (i > 16) throw new TrollsDontDoBigNumbersException

    i match {
      case 1 => One
      case 2 => Two
      case 3 => Three
      case 4 => Many
      case 16 => Lots
      case _ => ComplexTrollNumber.int2ComplexTrollNumbers(i)
    }
  }
}

