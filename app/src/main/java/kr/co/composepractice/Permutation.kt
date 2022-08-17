package kr.co.composepractice


val totalPermutationList = mutableListOf<Array<String>>()

fun main(args : Array<String>) {

    val array = arrayOf("A" , "B" , "C")

    permutation(array , 0)

    for (i in 0 until totalPermutationList.size) {
        println()
        for (j in totalPermutationList[i].indices) {
            print(totalPermutationList[i][j])
        }
    }

}

private fun permutation(array: Array<String> , depth : Int) {

    fun swap(i : Int , j : Int) {
        array[i] += array[j]
        array[j] = array[i].first().toString()
        array[i] = array[i].last().toString()
    }

    if(depth == array.size) {
        totalPermutationList.add(array.clone())
    }

    for(i in depth until array.size) {
        swap(depth , i)
        permutation(array = array , depth = depth + 1)
        swap(depth , i)
    }

}