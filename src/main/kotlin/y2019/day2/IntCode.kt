package y2019.day2

import y2019.day2.IntCode.OP_CODES.ADD
import y2019.day2.IntCode.OP_CODES.EXIT
import y2019.day2.IntCode.OP_CODES.MULTIPLY

class IntCode(val input: IntArray) {
    object OP_CODES {
        const val ADD = 1
        const val MULTIPLY = 2
        const val EXIT = 99
    }

    var position = 0

    fun compute() {
        position = 0
        while (true) {
            val opcode = input[position]
            when (opcode) {
                ADD -> add()
                MULTIPLY -> multiply()
                EXIT -> return
                else -> throw InvalidOPCodeException(opcode)
            }
        }
    }

    private fun add() {
        val augend = input[input[++position]]
        val addend = input[input[++position]]
        input[input[++position]] = augend + addend
        position++
    }

    private fun multiply() {
        val multiplicand  = input[input[++position]]
        val multiplier  = input[input[++position]]
        input[input[++position]] = multiplicand  * multiplier
        position++
    }
}

class InvalidOPCodeException(val opcode: Int) : Throwable()
