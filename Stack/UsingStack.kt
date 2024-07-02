package Stack
import java.util.*

fun main() {
    val stack = Stack<Int>()

    //creating a scanner
    val sc = Scanner(System.`in`)

    println("Enter 4 elements:")
    stack.push(sc.nextInt())
    stack.push(sc.nextInt())
    stack.push(sc.nextInt())
    stack.push(sc.nextInt())

    println("Stack: $stack")

    val removedElement = stack.pop()
    println("Popped/Removed element: $removedElement")

    println("Stack after popping: $stack")
}