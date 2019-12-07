package y2018.day1

class DoubleFrequencyFinder {

    fun findDoubleFrequency(vararg changes: Int): Int {
        val device = Device()
        val frequencies = mutableSetOf(device.frequency)

        while (true) {
            changes.forEach { change ->
                device.changeFrequency(change)
                if (frequencies.contains(device.frequency)) {
                    return device.frequency
                }
                frequencies.add(device.frequency)
            }
        }
    }

}