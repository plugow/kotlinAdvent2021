fun main() {

    fun part1(input: List<String>): Int {
        return input.mapNotNull<String, List<Point>> {
            val coordintates = it.split(" -> ", ",").map(String::toInt)
            val x1 = coordintates[0]
            val y1 = coordintates[1]
            val x2 = coordintates[2]
            val y2 = coordintates[3]
            if (x1 != x2 && y1 != y2) {
                null
            } else {
                buildList {
                    if (x1==x2){
                        if (y1<y2){
                            for (i in y1..y2) {
                                add(Point(x1, i))
                            }
                        } else {
                            for (i in y2..y1) {
                                add(Point(x1, i))
                            }
                        }
                    } else {
                        if (x1<x2){
                            for (i in x1..x2) {
                                add(Point(i, y1))
                            }
                        } else {
                            for (i in x2..x1) {
                                add(Point(i, y1))
                            }
                        }
                    }
                }
            }
        }
                .flatten()
                .groupingBy { it }
                .eachCount()
                .filter { it.value >= 2 }
                .size
    }

    fun part2(input: List<String>): Int {
        return input.mapNotNull<String, List<Point>> {
            val coordintates = it.split(" -> ", ",").map(String::toInt)
            val x1 = coordintates[0]
            val y1 = coordintates[1]
            val x2 = coordintates[2]
            val y2 = coordintates[3]


            if (x1==y1 && x2==y2 || x1==y2 && x2 == y1){
                buildList {
                    if (x1<x2){
                        for ((index, value) in (x1..x2).withIndex()) {
                            add(Point(value, y1+index))
                        }
                    } else {
                        for ((index, value) in (x2..x1).withIndex()) {
                            add(Point(value, y2 + index))
                        }
                    }
                }
            } else if (x1==x2 || y1==y2) {
                buildList {
                    if (x1==x2){
                        if (y1<y2){
                            for (i in y1..y2) {
                                add(Point(x1, i))
                            }
                        } else {
                            for (i in y2..y1) {
                                add(Point(x1, i))
                            }
                        }
                    } else {
                        if (x1<x2){
                            for (i in x1..x2) {
                                add(Point(i, y1))
                            }
                        } else {
                            for (i in x2..x1) {
                                add(Point(i, y1))
                            }
                        }
                    }
                }
            } else {
                null
            }
        }
                .flatten()
                .groupingBy { it }
                .eachCount()
                .filter { it.value >= 2 }
                .size
    }

    val testInput = readInput("Day05_test")
    println(part2(testInput))
    check(part2(testInput) == 12)

    val input = readInput("Day05")
    println(part2(input))

}

data class Point(val x: Int, val y: Int)