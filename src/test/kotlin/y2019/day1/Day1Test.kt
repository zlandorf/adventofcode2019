package y2019.day1

import InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day1Test {

    @Test
    fun `should compute fuel`() {
        val fuelCalculator = FuelCalculator()

        assertThat(fuelCalculator.calculate(12)).isEqualTo(2)
        assertThat(fuelCalculator.calculate(14)).isEqualTo(2)
        assertThat(fuelCalculator.calculate(1969)).isEqualTo(654)
        assertThat(fuelCalculator.calculate(100756)).isEqualTo(33583)
    }

    @Test
    fun `should consider additional fuel`() {
        val fuelCalculator = AdvancedFuelCalculator()

        assertThat(fuelCalculator.calculate(12)).isEqualTo(2)
        assertThat(fuelCalculator.calculate(14)).isEqualTo(2)
        assertThat(fuelCalculator.calculate(1969)).isEqualTo(966)
        assertThat(fuelCalculator.calculate(100756)).isEqualTo(50346)
    }

    @Test
    fun `should find solution part 1`() {
        val input = InputReader.readLines("day1/input.txt")
        val fuelCalculator = FuelCalculator()

        val fuelRequired = input
            .map { it.toInt() }
            .sumBy { fuelCalculator.calculate(it) }

        println("Fuel required: $fuelRequired")
    }

    @Test
    fun `should find solution part 2`() {
        val input = InputReader.readLines("day1/input.txt")
        val fuelCalculator = AdvancedFuelCalculator()

        val fuelRequired = input
            .map { it.toInt() }
            .sumBy { fuelCalculator.calculate(it) }

        println("Fuel required: $fuelRequired")
    }

}