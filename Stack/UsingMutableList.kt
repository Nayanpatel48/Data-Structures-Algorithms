package Stack
import java.util.*

fun main()
{
    val stack = mutableListOf<Int>()

    //creating a scanner
    val sc = Scanner(System.`in`)

    println("Enter 4 numbers:")
    stack.add(sc.nextInt())
    stack.add(sc.nextInt())
    stack.add(sc.nextInt())
    stack.add(sc.nextInt())

    stack.forEach {item -> print(" ["+ item + "]")}
    println()

    println("Popped/Removed element:"+stack.removeLast())

    print("After removing top element stack is:")

    stack.forEach {item -> print(" ["+ item + "]")}
}