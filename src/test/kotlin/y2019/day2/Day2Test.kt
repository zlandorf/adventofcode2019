package y2019.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day2Test {

    @Test
    fun `test example 1`() {
        val intcode = IntCode(intArrayOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50))

        intcode.compute()

        assertThat(intcode.input).isEqualTo(intArrayOf(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50))
    }

    @Test
    fun `test example 2`() {
        val intcode = IntCode(intArrayOf(1, 0, 0, 0, 99))

        intcode.compute()

        assertThat(intcode.input).isEqualTo(intArrayOf(2,0,0,0,99))
    }

    @Test
    fun `test example 3`() {
        val intcode = IntCode(intArrayOf(2, 3, 0, 3, 99))

        intcode.compute()

        assertThat(intcode.input).isEqualTo(intArrayOf(2,3,0,6,99))
    }

    @Test
    fun `test example 4`() {
        val intcode = IntCode(intArrayOf(2, 4, 4, 5, 99, 0))

        intcode.compute()

        assertThat(intcode.input).isEqualTo(intArrayOf(2,4,4,5,99,9801))
    }

    @Test
    fun `test example 5`() {
        val intcode = IntCode(intArrayOf(1, 1, 1, 4, 99, 5, 6, 0, 99))

        intcode.compute()

        assertThat(intcode.input).isEqualTo(intArrayOf(30,1,1,4,2,5,6,0,99))
    }

    @Test
    fun `solution part 1`() {
        val input = InputReader.readText("y2019/day2/input.txt").split(",").map { it.toInt() }.toIntArray()
        input[1] = 12
        input[2] = 2

        IntCode(input).run {
            compute()
            println("The value left at position 0 is ${this.input[0]}")
        }
    }

    @Test
    fun `solution part 2`() {
        IntRange(0, 99).forEach { noun ->
            IntRange(0, 99).forEach { verb ->
                val input = InputReader.readText("y2019/day2/input.txt").split(",").map { it.toInt() }.toIntArray()
                input[1] = noun
                input[2] = verb

                try {
                    IntCode(input).run {
                        compute()
                        println("$noun : $verb = ${this.input[0]}")
                        if (this.input[0] == 19690720) {
                            println("The combination is noun = $noun and verb = $verb. Result is ${100 * noun + verb}")
                            return
                        }
                    }
                } catch (e: InvalidOPCodeException) {
                    println("boum $noun : $verb, ${e.opcode}")
                }
            }
        }
    }

}