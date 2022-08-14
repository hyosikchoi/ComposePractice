package kr.co.composepractice.ui

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*

var totalCount = Integer.MAX_VALUE

fun main(args : Array<String>) {

    val bf = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(bf.readLine())


    val a = st.nextToken()

    val b = st.nextToken()

    if(a.length == b.length) {
        var count = 0
        for(i in a.indices) {
            if(a[i] != b[i]) count++
        }
        totalCount = min(totalCount,count)
    } else {
        var bIndex = 0
        for(i in 0..b.length - a.length) {
            var count = 0
            for(j in a.indices) {
                if(a[j] != b[bIndex+j]) count++
            }
            bIndex++
            totalCount = min(totalCount,count)
        }
    }

    print(totalCount)

}