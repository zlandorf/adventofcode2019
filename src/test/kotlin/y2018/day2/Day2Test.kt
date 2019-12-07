package y2018.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day2Test {

    @Test
    fun `Example 1`() {
        val scanner = Scanner()

        assertThat(scanner.checksum(listOf(
            "abcdef",
            "bababc",
            "abbcde",
            "abcccd",
            "aabcdd",
            "abcdee",
            "ababab"
        ))).isEqualTo(12)
    }

    @Test
    fun `Example 2`() {
        val scanner = Scanner()

        assertThat(scanner.commonLetters(listOf(
            "abcde",
            "fghij",
            "klmno",
            "pqrst",
            "fguij",
            "axcye",
            "wvxyz"
        ))).isEqualTo("fgij")
    }

    @Test
    fun `Solution part 1`() {
        val input = InputReader.readLines("y2018/day2/input.txt")
        val scanner = Scanner()

        println("Checksum is ${scanner.checksum(input)}")
    }

    @Test
    fun `Solution part 2`() {
        val input = InputReader.readLines("y2018/day2/input.txt")
        val scanner = Scanner()

        println("Common letter are ${scanner.commonLetters(input)}")
    }
}
