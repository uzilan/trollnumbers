package trollnumbers

/**
 * A class for creating complex troll numbers, given a list of troll numbers
 *
 * For simple troll numbers, see [SimpleTrollNumber]
 *
 * For parsing troll numbers from strings, see [toTrollNumber]
 *
 * @property trollNumbers A list of troll numbers to construct the complex troll number from
 * @constructor Create a complex troll number given a list of troll numbers
 */
data class ComplexTrollNumber(private val trollNumbers: List<TrollNumber> = listOf()) : TrollNumber {

    /** The numeric value of this complex troll number */
    override val value: Int
        get() = trollNumbers.sumBy { tn -> tn.value }

    /** The string representation of this complex troll number */
    override fun toString(): String {
        return trollNumbers.joinToString("-")
    }
}