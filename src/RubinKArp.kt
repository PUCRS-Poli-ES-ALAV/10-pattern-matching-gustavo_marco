package main

object RubinKarp {
    private const val primeNumb: Long = 1013
    private const val R = 256
    var count = 0
    fun run(s1: String, s2: String): Int {
        val m = s1.length
        val n = s2.length
        val s1Hash = hash(s1, m)
        for (i in 0..n - m) {
            count++
            val s2Hash = hash(s2.substring(i, i + m), m)
            if (s1Hash == s2Hash) if (s2.substring(i, i + m) == s1) {
                return i
            }
        }
        return n
    }

    private fun hash(s: String, M: Int): Long {
        var h: Long = 0
        count++
        for (j in 0 until M) h = (h * R + s[j].toLong()) % primeNumb
        return h
    }
}
