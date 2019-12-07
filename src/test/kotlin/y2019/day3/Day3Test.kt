package y2019.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day3Test {

    @Test
    fun `Test examples part 1`() {
        assertThat(IntersectionCalculator(
            "R8,U5,L5,D3",
            "U7,R6,D4,L4"
        ).closestIntersection()).isEqualTo(6)

        assertThat(IntersectionCalculator(
            "R75,D30,R83,U83,L12,D49,R71,U7,L72",
            "U62,R66,U55,R34,D71,R55,D58,R83"
        ).closestIntersection()).isEqualTo(159)

        assertThat(IntersectionCalculator(
            "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
            "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
        ).closestIntersection()).isEqualTo(135)
    }

    @Test
    fun `Test examples part 2`() {
        assertThat(IntersectionCalculator(
            "R8,U5,L5,D3",
            "U7,R6,D4,L4"
        ).intersectionWithFewestSteps()).isEqualTo(30)

        assertThat(IntersectionCalculator(
            "R75,D30,R83,U83,L12,D49,R71,U7,L72",
            "U62,R66,U55,R34,D71,R55,D58,R83"
        ).intersectionWithFewestSteps()).isEqualTo(610)

        assertThat(IntersectionCalculator(
            "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51",
            "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
        ).intersectionWithFewestSteps()).isEqualTo(410)
    }

    @Test
    fun `solution part 1`() {
        val input = InputReader.readLines("y2019/day3/input.txt")

        println("closest is: ${IntersectionCalculator(input[0], input[1]).closestIntersection()}")
    }

    @Test
    fun `solution part 2`() {
        val input = InputReader.readLines("y2019/day3/input.txt")

        println("closest is: ${IntersectionCalculator(input[0], input[1]).intersectionWithFewestSteps()}")
    }

}