package y2018.day1

import InputReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day1Test {

    @Test
    fun `Example 1`() {
        val device = Device()

        device.changeFrequency(1)
        assertThat(device.frequency).isEqualTo(1)

        device.changeFrequency(-2)
        assertThat(device.frequency).isEqualTo(-1)

        device.changeFrequency(3)
        assertThat(device.frequency).isEqualTo(2)

        device.changeFrequency(1)
        assertThat(device.frequency).isEqualTo(3)
    }

    @Test
    fun `Example 2`() {
        val device = Device()
        device.changeFrequency(+1, +1, +1)
        assertThat(device.frequency).isEqualTo(3)
    }

    @Test
    fun `Example 3`() {
        val device = Device()
        device.changeFrequency(+1, +1, -2)
        assertThat(device.frequency).isEqualTo(0)
    }

    @Test
    fun `Example 4`() {
        val device = Device()
        device.changeFrequency(-1, -2, -3)
        assertThat(device.frequency).isEqualTo(-6)
    }

    @Test
    fun `Example 5`() {
        val doubleFrequencyFinder = DoubleFrequencyFinder()
        val doubleFrequency = doubleFrequencyFinder.findDoubleFrequency(+1, -2, +3, +1, +1, -2)
        assertThat(doubleFrequency).isEqualTo(2)
    }

    @Test
    fun `Example 6`() {
        val finder = DoubleFrequencyFinder()
        assertThat(finder.findDoubleFrequency(+1, -1)).isEqualTo(0)
        assertThat(finder.findDoubleFrequency(+3, +3, +4, -2, -4)).isEqualTo(10)
        assertThat(finder.findDoubleFrequency(-6, +3, +8, +5, -6)).isEqualTo(5)
        assertThat(finder.findDoubleFrequency(+7, +7, -2, -7, -4)).isEqualTo(14)
    }

    @Test
    fun `Solution part 1`() {
        val device = Device()
        val input = InputReader.readLines("y2018/day1/input.txt").map { it.toInt() }.toIntArray()
        device.changeFrequency(*input)
        println("Final frequency is ${device.frequency}")
    }

    @Test
    fun `Solution part 2`() {
        val input = InputReader.readLines("y2018/day1/input.txt").map { it.toInt() }.toIntArray()
        val finder = DoubleFrequencyFinder()
        println("First frequency reached twice is ${finder.findDoubleFrequency(*input)}")
    }

}