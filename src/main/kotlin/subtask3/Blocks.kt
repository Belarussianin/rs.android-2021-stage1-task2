package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {

        fun sumIntOfArray(array: Array<*>): Int {
            var sum = 0
            for (i in array) {
                if (i is Int) {
                    sum += i
                }
            }
            return sum
        }

        fun concatStringOfArray(array: Array<*>): String {
            var line = ""
            for (elem in array) {
                if (elem is String) {
                    line = line.plus(elem)
                }
            }
            return line
        }

        fun parseClosestDateOfArray(array: Array<*>): String {
            val now = LocalDate.now()
            var maxDate = LocalDate.MIN
            for (elem in array) {
                if (elem is LocalDate) {
                    elem.let {
                        if (it.isBefore(now) && it.isAfter(maxDate)) {
                            maxDate = it
                        }
                    }
                }
            }
            return if (maxDate.isEqual(LocalDate.MIN)) throw Exception("No valid data passed") else maxDate.format(
                DateTimeFormatter.ofPattern("d.M.y")
            )
        }

        when (blockB) {
            String::class -> {
                return concatStringOfArray(blockA)
            }
            Int::class -> {
                return sumIntOfArray(blockA)
            }
            LocalDate::class -> {
                return parseClosestDateOfArray(blockA)
            }
        }
        throw Exception("No valid data passed")
    }
}