package subtask2

class Abbreviation {
    fun abbreviationFromA(a: String, b: String): String {
        var aArray = a
        for (elemA in aArray) {
            if (!b.contains(elemA, true)) {
                aArray = aArray.replace(elemA.toString(), "", true)
            }
        }
        return if (aArray.equals(b,true)) "YES" else "NO"
    }
}