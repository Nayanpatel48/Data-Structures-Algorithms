package stackJava

import java.util.Scanner

class Stack
{
    //stack declared
    val stack = mutableListOf<String>()

    fun push()
    {
        val sc = Scanner(System.`in`) // scanner created to take input from the user
        println("Enter element:")
        val ele = sc.nextLine()
        stack.add(ele)
        println(" $ele pushed successfully!!")
    }
    fun pop() : Any // you can return any datatype
    {
        if (stack.isEmpty())
            return 0
        else
        {
            val a = stack.removeLast()
            return a
        }
    }
    fun peek() : Any // you can return any datatype
    {
        if (stack.isEmpty())
            return 0
        else
        {
            val a= stack[stack.size-1]
            return a
        }
    }
    fun display()
    {
        if (stack.isEmpty())
            println("Stack is empty !!")
        else
        {
            println("Stack data:")
            stack.forEach {
                    item -> print("[$item]")
            }
        }
    }
}
fun main()
{
    val newStack = Stack()
    val newSc = Scanner(System.`in`)

    //infinite loop
    while (true)
    {
        println("-------------------------------------------------------------")
        println("Press 1 = push")
        println("Press 2 = Pop")
        println("Press 3 = Peek")
        println("Press 4 = Display stack")
        println("Press 5 = Exit")
        var choice = newSc.nextInt()

        when(choice)
        {
            1 -> {
                newStack.push()
                continue
            }
            2 -> {
                val a = newStack.pop()
                if (a==0)
                    println("Stack has no elements !")
                else
                    println("$a deleted from top of the stack!")
                continue
            }
            3 -> {
                val a = newStack.peek()
                if (a==0)
                    println("Stack has no elements !")
                else
                    println("$a deleted from top of the stack!")
                continue
            }
            4 -> {
                newStack.display()
                println()
                continue
            }
            5 -> break
        }
    }
    println("-------------------------------------------------------------")
}