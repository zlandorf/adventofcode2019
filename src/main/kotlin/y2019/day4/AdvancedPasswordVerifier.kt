package y2019.day4

class AdvancedPasswordVerifier {
    fun verify(password: String): Boolean {
        return digitsIncrease(password) && exactlyTwoAdjacentDigitsMatch(password)
    }

    private fun digitsIncrease(password: String) =
        (1 until password.length).all { i -> password[i] >= password[i - 1] }

    private fun exactlyTwoAdjacentDigitsMatch(password: String): Boolean {
        val charsMap = mutableMapOf<Char, Int>()
        password.forEach { charsMap[it] = charsMap.getOrDefault(it, 0) + 1 }
        return charsMap.values.any { it == 2 }
    }
}
