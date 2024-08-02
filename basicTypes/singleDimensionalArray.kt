package basicTypes

fun main()
{
    //remember array size will never change
    //creates an array with element 1,2,3
    val simpleArray : Array<Int> = arrayOf(1,2,3) // if not mention Array<Int> its ok

    println(simpleArray.joinToString(" "))

    //create an array of given size with 5 null elements
    val nullArray : Array<Int?> = arrayOfNulls(5)
    println(nullArray.joinToString(" "))

    //empty array created with sie always 0
    var emptyArray = emptyArray<String>()
    //also valid option
    var emptyArray1 : Array<String> = emptyArray()
    println(emptyArray1.size)
    println(emptyArray.size)

    //creating as well as initializing it
    var array = Array<Int>(3) {5}
    println(array.joinToString(" "))

    //creating array of custom size and with all elements zer0
    val size = 5
    val myArray = Array<Int>(size) {0}
    for (i in myArray)
        println(i)
}