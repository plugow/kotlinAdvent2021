fun main() {
    class Summary(val measurementIncreasesAmount: Int = -1, val previous: Int = 0)

    fun part1(input: List<Int>): Int {
        val increasedAmount = input.fold(Summary()) { summary, next ->
            if (next > summary.previous) {
                Summary(summary.measurementIncreasesAmount + 1, next)
            } else {
                Summary(summary.measurementIncreasesAmount, next)
            }
        }
        return increasedAmount.measurementIncreasesAmount
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test").map(String::toInt)
    check(part1(testInput) == 11)

    val input = readInput("Day01").map(String::toInt)
    println(part1(input))
}
