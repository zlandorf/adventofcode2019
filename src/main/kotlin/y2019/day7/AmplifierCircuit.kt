package y2019.day7

import java.lang.RuntimeException

class AmplifierCircuit(val input: IntArray) {
    fun maxThrusterSignal(sequence: IntArray): Int {
        var output = 0

        val outputWriter = object : OutputWriter {
            override fun write(value: Int) {
                output = value
            }
        }

        sequence.forEach {
            val inputReader = object : UserInputReader {
                val inputs = listOf(it, output)
                var currentIndex = 0

                override fun read(): Int {
                    val input = inputs[currentIndex]
                    currentIndex = (currentIndex + 1) % inputs.size
                    return input
                }
            }
            IntCode(input, inputReader, outputWriter).run { compute() }
        }

        return output
    }

    fun maxThrusterSignalSequence(): IntArray {
        return permutations(intArrayOf(0, 1, 2, 3, 4)).maxBy {
            maxThrusterSignal(it)
        } ?: throw RuntimeException("Couldn't find max")
    }

    private fun permutations(intArray: IntArray): List<IntArray> {
        return PermutationGenerator(intArray).permutations(0, intArray.size - 1)
    }

    class PermutationGenerator(private val sequence: IntArray) {
        fun permutations(l: Int, r: Int): List<IntArray> {
            if (l == r) {
                return listOf(sequence)
            }

            return (l .. r ).flatMap { i ->
                swap(l, i)
                val permutations = permutations(l + 1, r).map { it.copyOf() }
                swap(l, i)
                permutations
            }
        }

        private fun swap(l: Int, r: Int): IntArray {
            val tmp = sequence[l]
            sequence[l] = sequence[r]
            sequence[r] = tmp
            return sequence
        }
    }

}
