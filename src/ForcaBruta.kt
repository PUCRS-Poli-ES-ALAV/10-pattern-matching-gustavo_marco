package main

class ForcaBruta (var s1: String, var s2: String) {
     var interation = 0
    fun run(): Int {
        var count = 0
        for (i in s1.indices) {
            interation++
            if (s1[i] == s2[count]) {
                if (count == s2.length - 1) {
                    return i - count
                }
                count++
            } else {
                count = 0
            }
        }
        return -1
    }
}
