fun Pair<Long, Long>.sum(): Long {
    return (this.first.toString() + this.second.toString()).toLong()
}

fun main() {
    fun calculate(line: String): Long {
        val numbers = line.map { it.toString().toLong() }

        var p = Pair(numbers[0], numbers[1])

        for (i in 0..<numbers.size - 1) {
            for (j in i + 1..<numbers.size) {
                val n = Pair(numbers[i], numbers[j])
                if (n.sum() > p.sum()) {
                    p = n
                }
            }
        }
        return p.sum()
    }

    fun part1(input: List<String>): Long {
        return input.fold(0.toLong()) { acc, it ->
            acc + calculate(it)
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }


    val input = readInput("Day3")
    val testInput = readInput("Day3_test")

    calculate("987654321111111").println()

    check(calculate("987654321111111") == 98.toLong())
    check(calculate("811111111111119") == 89.toLong())
    check(calculate("234234234234278") == 78.toLong())
    check(calculate("818181911112111") == 92.toLong())

    part1(testInput).println()
    check(part1(testInput) == 357.toLong())


    part1(input).println()
    part2(input).println()
}


