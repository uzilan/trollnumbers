package trollnumbers

import scala.language.implicitConversions

/** Represents a complex [[trollnumbers.TrollNumber]], such as `Many-Many-One`
  *
  * @param trollNumbers a List of [[trollnumbers.TrollNumber]]s which builds this complex [[trollnumbers.TrollNumber]]
  */
class ComplexTrollNumber(trollNumbers: List[TrollNumber]) extends TrollNumber(trollNumbers.foldLeft(0)(_ + _)) {
  /** Describes this [[trollnumbers.ComplexTrollNumber]] */
  override def toString: String = trollNumbers.mkString("-")
}

/** Allows converting an `Int` into a [[trollnumbers.ComplexTrollNumber]] */
object ComplexTrollNumber {
  /** Allows converting an `Int` into a [[trollnumbers.ComplexTrollNumber]]
    *
    * @param i the `Int` to convert
    * @return the converted [[trollnumbers.ComplexTrollNumber]]
    */
  implicit def int2ComplexTrollNumbers(i: Int): TrollNumber = {
    val manys = i / 4
    val rest = i - manys * 4
    val list = List.fill(manys)(TrollNumber.Many)
    if (rest == 0) new ComplexTrollNumber(list)
    else new ComplexTrollNumber(list :+ TrollNumber(rest))
  }
}
