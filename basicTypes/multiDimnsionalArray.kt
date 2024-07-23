package basicTypes

fun main(){
    val twoDimensionalArray = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6)
    )
    println(twoDimensionalArray[3][2])//6
}