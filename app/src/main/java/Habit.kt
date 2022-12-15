import android.widget.Toast

class Habit constructor(var name: String?,
                        var time: Int,
                        var numSessions: Int,
                        var days: ArrayList<Int>,
                        var minutesOrHours: Boolean)
{
    var sessionsPerDay = 0
    var daysPerWeek = numSessions

    init {
        var daysPerWeek = numSessions
        if (!(days.contains(0))) {
            daysPerWeek = days.size
        }
        else if(numSessions > 7) {
            daysPerWeek = 7
        }
        sessionsPerDay = numSessions / daysPerWeek
    }

    fun setDays(): ArrayList<Int> {
        if(days.contains(0)) {
            val daySpacing: Int = 7 / daysPerWeek
            var sum = 1
            while (sum <= 7 && days.size <= daysPerWeek) {
                days.add(sum)
                sum += daySpacing
            }
            days.remove(0)
        }
        return days
    }

    fun checkErrors(): Int {
        var totalTime: Double = (time * sessionsPerDay).toDouble()
        if(!minutesOrHours)
            totalTime /= 60.0

        if(totalTime >= 16) {
            return 1
        }
        else if(sessionsPerDay >= 5) {
            return 2
        }
        return 3
    }

    override fun toString(): String {
        var habit = ""
        for(i in 1..sessionsPerDay) {
            habit += "$name \n $time "
            if (minutesOrHours)
                habit += "hours"
            else
                habit += "minutes"
            habit += "\n \n"
        }
        return habit
    }
}