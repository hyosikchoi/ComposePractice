package kr.co.composepractice.ui

val totalCombinationList = mutableListOf<List<String>>()

fun main(args : Array<String>) {

    val array = arrayOf("A", "B", "C")

    for (i in 1..array.size) combination(array, Array<Boolean>(array.size) { false },0 , i)

    println(totalCombinationList)

}

private fun combination(array : Array<String> , visit : Array<Boolean> ,start : Int , target : Int) {

    if(target == 0) {
        val addArray = array.filterIndexed {
                index , value ->
            visit[index]
        }
        totalCombinationList.add(addArray)
    }

    for(i in start until array.size) {
        visit[i] = true
        combination(array , visit , i + 1 , target -1)
        visit[i] = false
    }

}
