package y2019.day6

import InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day6Test {

    @Test
    fun `Test example 1`() {
        val verifier = MapVerifier()
        val input = listOf("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L")
        assertThat(verifier.checksum(input)).isEqualTo(42)
    }

    @Test
    fun `Test example 2`() {
        val verifier = MapVerifier()
        val input = listOf("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L", "K)YOU", "I)SAN")
        assertThat(verifier.minimumTransferCount(input, "YOU", "SAN")).isEqualTo(4)
    }

    @Test
    fun `Solution part 1`() {
        val input = InputReader.readLines("y2019/day6/input.txt")
        val verifier = MapVerifier()

        println("The total number of direct and indirect orbits is ${verifier.checksum(input)}")
    }

    @Test
    fun `Solution part 2`() {
        val input = InputReader.readLines("y2019/day6/input.txt")
        val verifier = MapVerifier()

        println("The minimum number of orbital transfers required is ${verifier.minimumTransferCount(input, "YOU", "SAN")}")
    }

}