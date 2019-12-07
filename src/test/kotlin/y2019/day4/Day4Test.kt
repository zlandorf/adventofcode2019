package y2019.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day4Test {

    @Test
    fun `Test examples`() {
        val verifier = PasswordVerifier()

        assertThat(verifier.verify("111111")).isTrue()
        assertThat(verifier.verify("223450")).isFalse()
        assertThat(verifier.verify("123789")).isFalse()
    }

    @Test
    fun `Test examples part 2`() {
        val verifier = AdvancedPasswordVerifier()

        assertThat(verifier.verify("112233")).isTrue()
        assertThat(verifier.verify("123444")).isFalse()
        assertThat(verifier.verify("111122")).isTrue()
    }

    @Test
    fun `Solution part 1`() {
        val verifier = PasswordVerifier()

        val count = IntRange(347312, 805915)
            .map { it.toString() }
            .count { verifier.verify(it) }

        println("$count passwords meet the criteria")
    }

    @Test
    fun `Solution part 2`() {
        val verifier = AdvancedPasswordVerifier()

        val count = IntRange(347312, 805915)
            .count { verifier.verify(it.toString()) }

        println("$count passwords meet the criteria")
    }

}