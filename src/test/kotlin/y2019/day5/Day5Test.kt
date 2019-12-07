package y2019.day5

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class Day5Test {

    @Mock
    lateinit var userInputReader: UserInputReader
    @Mock
    lateinit var outputWriter: OutputWriter

    @Test
    fun `Test example 1`() {
        val intcode = IntCode(intArrayOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50), userInputReader, outputWriter)

        intcode.compute()

        Assertions.assertThat(intcode.input).isEqualTo(intArrayOf(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50))
    }

    @Test
    fun `Test example 2`() {
        val intcode = IntCode(intArrayOf(1002, 4, 3, 4, 33), userInputReader, outputWriter)

        intcode.compute()

        Assertions.assertThat(intcode.input).isEqualTo(intArrayOf(1002, 4, 3, 4, 99))
    }

    @Test
    fun `Solution part 1`() {
        val input = InputReader.readText("y2019/day5/input.txt").split(",").map { it.toInt() }.toIntArray()
        val consoleOutputWriter = object : OutputWriter {
            override fun write(value: Int) {
                println("output: $value")
            }
        }
        `when`(userInputReader.read()).thenReturn(1)

        IntCode(input, userInputReader, consoleOutputWriter).run {
            compute()
        }
    }

    @Test
    fun `Solution part 2`() {
        val input = InputReader.readText("y2019/day5/input.txt").split(",").map { it.toInt() }.toIntArray()
        val consoleOutputWriter = object : OutputWriter {
            override fun write(value: Int) {
                println("output: $value")
            }
        }
        `when`(userInputReader.read()).thenReturn(5)

        IntCode(input, userInputReader, consoleOutputWriter).run {
            compute()
        }
    }

}