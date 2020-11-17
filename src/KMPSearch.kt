package main

 object KMPSearch{
    var interactions = 0
    var instruction = 0

    fun KMPSearch(pat: String, txt: String): Int {
        val M = pat.length 
        instruction += 2
        val N = txt.length 
        instruction += 2

        val lps = IntArray(M)
        instruction += 2
        var j = 0
        instruction += 2

        computeLPSArray(pat, M, lps)
        instruction++
        var i = 0
        while (i < N) {
            interactions++
            instruction++
            if (pat[j] == txt[i]) {
                j++
                i++
                instruction += 2
            }
            instruction += 3
            if (j == M) {
                println("Found pattern " + "at index " + (i - j))
                j = lps[j - 1]
                instruction += 8 
            } else if (i < N && pat[j] != txt[i]) {
                if (j != 0) j = lps[j - 1] else i = i + 1
                instruction += 3
            }
        }
        instruction++
        return j
    }

    fun computeLPSArray(pat: String, M: Int, lps: IntArray) {
        // tamanho do maior prefixo sufixo anterior
        var len = 0
        var i = 1
        lps[0] = 0
        instruction += 3


        while (i < M) {
            interactions++
            instruction += 3
            if (pat[i] == pat[len]) {
                len++
                lps[i] = len
                i++
                instruction += 4
            } else
            {
                if (len != 0) {
                    len = lps[len - 1]
                    instruction += 2
                } else
                {
                    lps[i] = len
                    i++
                    instruction += 3
                }
                instruction++
            }
        }
    }
}
