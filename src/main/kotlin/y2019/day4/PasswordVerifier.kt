package y2019.day4

class PasswordVerifier {

    fun verify(password: String): Boolean {
        return digitsIncrease(password) && twoAdjacentDigitsMatch(password)
    }

    private fun digitsIncrease(password: String) =
        (1 until password.length).all { i -> password[i] >= password[i - 1] }

    private fun twoAdjacentDigitsMatch(password: String) =
        (1 until password.length).any { i -> password[i] == password[i - 1] }
}
