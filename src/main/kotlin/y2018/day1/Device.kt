package y2018.day1

class Device {
    var frequency = 0
        private set

    fun changeFrequency(vararg frequencies: Int) {
        frequencies.forEach { frequency += it }
    }

}
