package Stack
import java.util.*

fun main() {
    val stack = ArrayDeque<Int>()

    //creating scanner
    val sc = Scanner(System.`in`)

    println("Enter 4 integer values:")
    stack.addFirst(sc.nextInt())
    stack.add(sc.nextInt())
    stack.add(sc.nextInt())
    stack.add(sc.nextInt())

    Display(stack)
    println("First element removed is:"+stack.removeFirst())
    Display(stack)
    println("First element removed is:"+stack.removeLast())
    Display(stack)

    println("Entering elements 4,6,6,67,908,67")
    stack.addAll(listOf(4,6,6,67,908,67))
    Display(stack)

    // remove the middle element
    val middleIndex = stack.size / 2
    println("The middle element from the stack deleted :"+stack.remove(middleIndex))
    Display(stack)
}
fun Display(stack: ArrayDeque<Int>)
{
    stack.forEach{ item -> print("["+ item + "]") }
    println()
    println("--------")
}
