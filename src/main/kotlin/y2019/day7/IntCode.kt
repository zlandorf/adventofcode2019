package y2019.day7

import y2019.day5.IntCode.OPCodes.ADD
import y2019.day5.IntCode.OPCodes.EQUALS
import y2019.day5.IntCode.OPCodes.EXIT
import y2019.day5.IntCode.OPCodes.INPUT
import y2019.day5.IntCode.OPCodes.JUMP_IF_FALSE
import y2019.day5.IntCode.OPCodes.JUMP_IF_TRUE
import y2019.day5.IntCode.OPCodes.LESS_THAN
import y2019.day5.IntCode.OPCodes.MULTIPLY
import y2019.day5.IntCode.OPCodes.OUTPUT
import y2019.day5.IntCode.ReadModes.POSITION

class IntCode(val input: IntArray, val userInputReader: UserInputReader, val outputWriter: OutputWriter) {
    object OPCodes {
        const val ADD = 1
        const val MULTIPLY = 2
        const val INPUT = 3
        const val OUTPUT = 4
        const val JUMP_IF_TRUE = 5
        const val JUMP_IF_FALSE = 6
        const val LESS_THAN = 7
        const val EQUALS = 8
        const val EXIT = 99
    }

    object ReadModes {
        const val POSITION = 0
        const val IMMEDIATE = 1
    }

    var position = 0

    fun compute() {
        position = 0
        while (true) {
            val instruction = parseInstruction()
            when (instruction.opcode) {
                ADD -> add(instruction)
                MULTIPLY -> multiply(instruction)
                INPUT -> input(instruction)
                OUTPUT -> output(instruction)
                JUMP_IF_TRUE -> jumpIfTrue(instruction)
                JUMP_IF_FALSE -> jumpIfFalse(instruction)
                LESS_THAN -> lessThan(instruction)
                EQUALS -> equalsInstruction(instruction)
                EXIT -> return
                else -> throw InvalidOPCodeException(instruction.opcode)
            }
        }
    }

    private fun jumpIfTrue(instruction: Instruction) {
        if (instruction.read(0) != 0) {
            position = instruction.read(1)
        } else {
            position += 1 + parameterCount(instruction.opcode)
        }
    }

    private fun jumpIfFalse(instruction: Instruction) {
        if (instruction.read(0) == 0) {
            position = instruction.read(1)
        } else {
            position += 1 + parameterCount(instruction.opcode)
        }
    }

    private fun lessThan(instruction: Instruction) {
        val first = instruction.read(0)
        val second = instruction.read(1)
        instruction.write(2, if (first < second) 1 else 0)
        position += 1 + parameterCount(instruction.opcode)
    }

    private fun equalsInstruction(instruction: Instruction) {
        val first = instruction.read(0)
        val second = instruction.read(1)
        instruction.write(2, if (first == second) 1 else 0)
        position += 1 + parameterCount(instruction.opcode)
    }

    private fun input(instruction: Instruction) {
        val input = userInputReader.read()
        instruction.write(0, input)
        position += 1 + parameterCount(instruction.opcode)
    }

    private fun output(instruction: Instruction) {
        outputWriter.write(instruction.read(0))
        position += 1 + parameterCount(instruction.opcode)
    }

    private fun add(instruction: Instruction) {
        val augend = instruction.read(0)
        val addend = instruction.read(1)
        instruction.write(2, augend + addend)
        position += 1 + parameterCount(instruction.opcode)
    }

    private fun multiply(instruction: Instruction) {
        val multiplicand = instruction.read(0)
        val multiplier = instruction.read(1)
        instruction.write(2, multiplicand * multiplier)
        position += 1 + parameterCount(instruction.opcode)
    }

    private fun parseInstruction(): Instruction {
        var raw = input[position]
        val opcode = raw % 100
        raw /= 100
        val parameters = (1 .. parameterCount(opcode)).map { i ->
            val parameter = Parameter(input[position + i], raw % 10)
            raw /= 10
            parameter
        }
        return Instruction(opcode, parameters, input)
    }

    private fun parameterCount(opcode: Int): Int {
        return when (opcode) {
            ADD -> 3
            MULTIPLY -> 3
            INPUT -> 1
            OUTPUT -> 1
            JUMP_IF_TRUE -> 2
            JUMP_IF_FALSE -> 2
            LESS_THAN -> 3
            EQUALS -> 3
            EXIT -> 0
            else -> throw InvalidOPCodeException(opcode)
        }
    }

    data class Instruction(val opcode: Int, private val parameters: List<Parameter>, private val input: IntArray) {
        fun read(paramIndex: Int) = if (parameters[paramIndex].mode == POSITION) input[parameters[paramIndex].value] else parameters[paramIndex].value
        fun write(paramIndex: Int, value: Int) {
            input[parameters[paramIndex].value] = value
        }
    }

    data class Parameter(val value: Int, val mode: Int)
}

interface UserInputReader {
    fun read(): Int
}

interface OutputWriter {
    fun write(value: Int): Unit
}


class InvalidOPCodeException(opcode: Int) : Throwable("invalid op code $opcode")
