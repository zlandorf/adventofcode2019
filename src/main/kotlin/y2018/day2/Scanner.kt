package y2018.day2

class Scanner {
    fun checksum(boxIds: List<String>): Int {
        val twice = lettersOccurNTimes(boxIds, 2)
        val thrice = lettersOccurNTimes(boxIds, 3)

        return twice * thrice
    }

    private fun lettersOccurNTimes(boxIds: List<String>, times: Int): Int {
        return boxIds.count { boxId ->
            val charCount = mutableMapOf<Int, Int>()
            boxId.chars().forEach { charCount[it] = charCount.getOrDefault(it, 0) + 1 }
            charCount.values.any { it == times }
        }
    }

    fun commonLetters(boxIds: List<String>): String {
        (boxIds.indices).forEach { i ->
            val boxId = boxIds[i]
            (i + 1 until boxIds.size).forEach { j ->
                val other = boxIds[j]
                boxId.differingCharacterIndex(other)?.let { differingIndex ->
                    return boxId.substring(0, differingIndex) + boxId.substring(differingIndex + 1)
                }
            }
        }
        return ""
    }

    private fun String.differingCharacterIndex(other: String): Int? {
        val differingIndices = (indices).filter { i -> this[i] != other[i] }
        if (differingIndices.size == 1) {
            return differingIndices[0]
        }
        return null
    }

}
