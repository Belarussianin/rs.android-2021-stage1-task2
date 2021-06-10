package subtask1

import java.lang.Exception
import java.time.DateTimeException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {
    fun toTextDay(day: String, month: String, year: String): String = try {
        LocalDateTime.of(year.toInt(), month.toInt(), day.toInt(), 0, 0)
            .format(DateTimeFormatter.ofPattern("d MMMM, eeee").withLocale(Locale("ru")))
    } catch (ex: DateTimeException) {
        "Такого дня не существует"
    } catch (ex: Exception) {
        ex.stackTrace.toString()
    }
}