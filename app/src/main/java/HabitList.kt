public class HabitList constructor() {

    var hl = arrayListOf<Habit>()

    init {

    }

    fun sunHabits(): String {
        var sunhabits = "FREE"
        for(i in 0 until hl.size) {
            var h = hl.get(i)
            if(h.days.contains(1)) {
                if (sunhabits == "FREE")
                    sunhabits = ""
                sunhabits += h.toString()
            }
        }
        return sunhabits
    }

    fun monHabits(): String {
        var monhabits = "FREE"
        for(i in 0 until hl.size) {
            var h = hl.get(i)
            if(h.days.contains(2)) {
                if (monhabits == "FREE")
                    monhabits = ""
                monhabits += h.toString()
            }
        }
        return monhabits
    }

    fun tuesHabits(): String {
        var tueshabits = "FREE"
        for(i in 0 until hl.size) {
            var h = hl.get(i)
            if(h.days.contains(3)) {
                if (tueshabits == "FREE")
                    tueshabits = ""
                tueshabits += h.toString()
            }
        }
        return tueshabits
    }

    fun wedHabits(): String {
        var wedhabits = "FREE"
        for(i in 0 until hl.size) {
            var h = hl.get(i)
            if(h.days.contains(4)) {
                if (wedhabits == "FREE")
                    wedhabits = ""
                wedhabits += h.toString()
            }
        }
        return wedhabits
    }

    fun thursHabits(): String {
        var thurshabits = "FREE"
        for(i in 0 until hl.size) {
            var h = hl.get(i)
            if(h.days.contains(5)) {
                if (thurshabits == "FREE")
                    thurshabits = ""
                thurshabits += h.toString()
            }
        }
        return thurshabits
    }

    fun friHabits(): String {
        var frihabits = "FREE"
        for(i in 0 until hl.size) {
            var h = hl.get(i)
            if(h.days.contains(6)) {
                if (frihabits == "FREE")
                    frihabits = ""
                frihabits += h.toString()
            }
        }
        return frihabits
    }

    fun satHabits(): String {
        var sathabits = "FREE"
        for(i in 0 until hl.size) {
            var h = hl.get(i)
            if(h.days.contains(7)) {
                if (sathabits == "FREE")
                    sathabits = ""
                sathabits += h.toString()
            }
        }
        return sathabits
    }

    override fun toString(): String {
        var str = ""
        for(i in 0 until hl.size)
            str += hl.get(i).toString()
        return str
    }
}