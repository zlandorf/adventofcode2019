package y2019.day7

import InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class Day7Test {

    @Test
    fun `Test sequence 1`() {
        val amplifierCircuit = AmplifierCircuit(intArrayOf(3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0))
        assertThat(amplifierCircuit.maxThrusterSignal(intArrayOf(4,3,2,1,0))).isEqualTo(43210)
    }

    @Test
    fun `Test sequence 2`() {
        val amplifierCircuit = AmplifierCircuit(intArrayOf(3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0))
        assertThat(amplifierCircuit.maxThrusterSignal(intArrayOf(0,1,2,3,4))).isEqualTo(54321)
    }

    @Test
    fun `Test sequence 3`() {
        val amplifierCircuit = AmplifierCircuit(intArrayOf(3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0))
        assertThat(amplifierCircuit.maxThrusterSignal(intArrayOf(1,0,4,3,2))).isEqualTo(65210)
    }

    @Test
    fun `Test find max sequence 1`() {
        val amplifierCircuit = AmplifierCircuit(intArrayOf(3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0))
        assertThat(amplifierCircuit.maxThrusterSignalSequence()).isEqualTo(intArrayOf(4,3,2,1,0))
    }

    @Test
    fun `Test find max sequence 2`() {
        val amplifierCircuit = AmplifierCircuit(intArrayOf(3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0))
        assertThat(amplifierCircuit.maxThrusterSignalSequence()).isEqualTo(intArrayOf(0,1,2,3,4))
    }

    @Test
    fun `Test find max sequence 3`() {
        val amplifierCircuit = AmplifierCircuit(intArrayOf(3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0))
        assertThat(amplifierCircuit.maxThrusterSignalSequence()).isEqualTo(intArrayOf(1,0,4,3,2))
    }

    @Test
    fun `Solution part 1`() {
        val input = InputReader.readText("y2019/day7/input.txt").split(",").map { it.toInt() }.toIntArray()

        val amplifierCircuit = AmplifierCircuit(input)
        val maxSignalSequence = amplifierCircuit.maxThrusterSignalSequence()
        println("Max sequence is ${amplifierCircuit.maxThrusterSignal(maxSignalSequence)}")
    }

    @Test
    fun `Solution part 2`() {
        val input = InputReader.readText("y2019/day7/input.txt").split(",").map { it.toInt() }.toIntArray()
    }

}