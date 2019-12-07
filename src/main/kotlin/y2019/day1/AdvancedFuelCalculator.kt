package y2019.day1

import java.lang.Integer.max

class AdvancedFuelCalculator {

    private val delegate = FuelCalculator()

    fun calculate(mass: Int): Int {
        if (mass <= 0) return 0
        val fuelRequirement = max(0, delegate.calculate(mass))
        return fuelRequirement + calculate(fuelRequirement)
    }
}
