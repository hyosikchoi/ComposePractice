package kr.co.composepractice.ui

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.sql.Date
import java.sql.Timestamp

fun main(args : Array<String>) {

    val buffer = BufferedReader(InputStreamReader(System.`in`))

    val n = buffer.readLine().toInt()

    val dp = Array<Int>(n+1) { 10000 }
    dp[3] = 1
    if(n > 4) {
        dp[5] = 1
        for(i in 6 until n+1) {
            dp[i] = min(dp[i-3], dp[i-5]) + 1
        }
    }

    if(dp[n] >= 10000) print(-1)
    else print(dp[n])

}


