package y2019.day3

import kotlin.math.abs

class IntersectionCalculator(firstWireInput: String, secondWireInput: String) {

    private val firstWireDirections = firstWireInput.toWireDirections()
    private val secondWireDirections = secondWireInput.toWireDirections()

    fun closestIntersection(): Int {
        return positions(firstWireDirections)
            .intersect(positions(secondWireDirections))
            .map { it.manhattanDistance() }
            .min() ?: throw NoIntersectionFoundException()
    }

    fun intersectionWithFewestSteps(): Int {
        val firstWirePositions = positions(firstWireDirections)
        val secondWirePositions = positions(secondWireDirections)
        return firstWirePositions
            .intersect(secondWirePositions)
            .map { firstWirePositions.indexOf(it) + secondWirePositions.indexOf(it) + 2 }
            .min() ?: throw NoIntersectionFoundException()
    }

    private fun positions(wire: List<WireDirection>): List<Position> {
        var position = Position(0, 0)
        return wire.flatMap {  instruction ->
            IntRange(1, instruction.distance).map {
                position = when (instruction.direction) {
                    "L" -> position.left()
                    "R" -> position.right()
                    "U" -> position.up()
                    else -> position.down()
                }
                position
            }
        }
    }

    private data class WireDirection(val direction: String, val distance: Int)
    private data class Position(val x: Int, val y: Int) {
        fun left() = Position(x - 1, y)
        fun right() = Position(x + 1, y)
        fun up() = Position(x, y + 1)
        fun down() = Position(x, y - 1)

        fun manhattanDistance() = abs(x) + abs(y)
    }

    private fun String.toWireDirections() = split(",").map {
        WireDirection(it.substring(0, 1), it.substring(1).toInt())
    }
}

class NoIntersectionFoundException : Throwable()
