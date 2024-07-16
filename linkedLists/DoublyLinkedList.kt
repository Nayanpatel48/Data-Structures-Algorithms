package linkedLists

import java.util.Scanner

//Node1 is the node name given just to avoide error in this package it is just a normal node
class Node1<Int>(var value: Int)
{
    var next: Node1<Int>? = null
    var prev: Node1<Int>? = null
}
class LinkedList1<Int>
{
    private var head: Node1<Int>? = null

    fun display()
    {
        if (head == null)
        {
            println("Linked list is empty!")
            return
        }
        //initialize the traversal
        var save = head
        //traversing nodes one by one
        while (save != null)
        {
            print("${save.value}->")
            save=save.next
        }
    }
    fun totalNodes() : kotlin.Int
    {
        //initialize traversal
        var save = head
        var i = 0

        //count the number of nodes in the list
        while (save != null)
        {
            i++
            save = save.next
        }
        //return value
        return i
    }

}
fun main()
{
    val linkedList1 = LinkedList1<Int>()
    //Scanner created for taking input
    val sc = Scanner(System.`in`)

    //infinite loop
    while (true)
    {
        println("Press 1 = display linked list")
        println("Press 2 = count number of nodes")
        println("Press 3 = insert at the beginning")
        println("Press 4 = insert at the ending")
        println("Press 5 = insert at specific location")
        println("Press 6 = insert after given node")
        println("Press 7 = insert before given node")
        println("Press 8 = delete from beginning")
        println("Press 9 = delete from ending")
        println("Press 10 = delete the specific node")
        println("Press 11 = delete after a given node")
        println("Press 12 = exit")
        println("Enter choice:")
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        var token = sc.nextInt()
        when (token)
        {
            1 -> {
                linkedList1.display()
                continue
            }
            2 -> {
                println(linkedList1.totalNodes())
                continue
            }
            3 -> {

                continue
            }
            4 -> {

                continue
            }
            5 -> {

                continue
            }
            6 -> {

                continue
            }
            7 -> {

                continue
            }
            8 -> {

                continue
            }
            9 -> {

                continue
            }
            10 -> {

                continue
            }
            11 -> {

                continue
            }
            12 -> break
        }
    }
}