fun main() {

    fun part1(input: List<String>): Int {
        return input
                .mapNotNull {
                    val (coordinateStr, valueStr) = it.split(" ")
                    when (coordinateStr) {
                        "forward" -> Direction(Coordinate.Forward, valueStr.toInt())
                        "up" -> Direction(Coordinate.Depth, -valueStr.toInt())
                        "down" -> Direction(Coordinate.Depth, valueStr.toInt())
                        else -> null
                    }
                }
                .groupBy ({ it.coordinate }, {it.value})
                .mapValues { it.value.sum() }
                .values
                .reduce { acc, i ->
                    acc * i
                }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)

    val input = readInput("Day02")
    println(part1(input))

}

enum class Coordinate {
    Depth,
    Forward
}

data class Direction(val coordinate: Coordinate, val value: Int)