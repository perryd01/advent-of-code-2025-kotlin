fun main() {


    fun sol(input: List<String>, regex: Regex): Long {
        return input.map {
            val e = it.split("-")
            Pair<Long, Long>(e[0].toLong(), e[1].toLong())
        }.fold(0.toLong()) { acc, it ->
            val r = it.first.rangeUntil(it.second)

            (acc + (it.first..it.second).filter { r ->
                regex.matches(r.toString())
            }.sum())
        }
    }

    fun part1(input: List<String>): Long {
        return sol(input, Regex("^(\\d+)\\1\$"))
    }

    fun part2(input: List<String>): Long {
        return sol(input, Regex("^(\\d+)\\1+\$"))
    }

    val testInput = readInput("Day02_test")[0].split(",")
    check(part1(testInput) == 1227775554.toLong())

    val input = readInput("Day2")[0].split(",")
    part1(input).println()
    part2(input).println()
}
