package calculator

@JvmInline
value class PositiveNumbers(private val numbers: List<PositiveNumber>) {
    fun add(): PositiveNumber = numbers.reduce { acc, positiveNumber -> acc + positiveNumber }
}
