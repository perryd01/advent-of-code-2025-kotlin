enum class Direction {
    LEFT, RIGHT
}

class Wheel {
    var pos = 0

    fun rotate(dir: Direction, amount: Int) {

    }
}

fun main() {

    fun part1(input: List<String>): Int {
        var pos = 50

        val timesZero = input.map { Pair(it.take(1), it.substring(1).toInt()) }.count {
            if (it.first == "L") {
                pos = ((pos - it.second).mod(100))
            } else {
                pos = ((pos + it.second).mod(100))
            }
            pos == 0
        }

        return timesZero
    }

    fun part2(input: List<String>): Int {
        var pos = 50
        var zeros = 0
        var times = 0

        input.map {
            Pair(it.take(1), it.substring(1).toInt())
        }.forEach {
            if (it.first == "L") {
                repeat(it.second) {
                    pos = (pos + 1) % 100
                    if (pos == 0) times++
                }
            } else {
                repeat(it.second) {
                    pos = (pos - 1) % 100
                    if (pos == 0) times++
                }
            }
        }

        return times
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)
    check(part2(listOf("R1000", "L1")) == 10)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
