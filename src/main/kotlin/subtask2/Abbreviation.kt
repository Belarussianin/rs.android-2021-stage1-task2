package subtask2

class Abbreviation {
    fun abbreviationFromA(a: String, b: String): String {
        var aArray = a.toUpperCase()
        for (elemB in b) {
            if (!aArray.contains(elemB, true)) {
                return "NO"
            }
        }
        for (elemA in aArray) {
            if (!b.contains(elemA, true)) {
                aArray = aArray.replace(elemA.toString(), "", true)
            }
        }
        return if (aArray == b) "YES" else "NO"
    }
}