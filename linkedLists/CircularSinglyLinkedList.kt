package linkedLists

import java.util.Scanner

//Node2 is the node name given just to avoid error in this package it is just a normal node
class Node2<Int>(var value: Int)
{
    var next: Node2<Int>? = null
    var prev: Node2<Int>? = null
}
class LinkedList2<Int>
{
    private var head: Node2<Int>? = null

}
fun main()
{
    val linkedList1 = LinkedList2<Int>()
    //Scanner created for taking input
    val sc = Scanner(System.`in`)

    //infinite loop
    while (true)
    {
        println("Press 1 = display linked list")
        println("Press 2 = count number of nodes")
        println("Press 3 = search for value")
        println("Press 4 = insert at the beginning")
        println("Press 5 = insert at the ending")
        println("Press 6 = insert node before node")
        println("Press 7 = insert node after node")
        println("Press 8 = insert at specific location")
        println("Press 9 = delete from beginning")
        println("Press 10 = delete from ending")
        println("Press 11 = delete after a given node")
        println("Press 12 = delete before a given node")
        println("Press 13 = delete the node with specific value")
        println("Press 14 = delete the node at specific position")
        println("Press 15 = exit")
        println("Enter choice:")
        var token = sc.nextInt()
        when (token)
        {
            1 -> {

                continue
            }
            2 -> {

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
            12 -> {

                continue
            }
            13 -> {

                continue
            }
            14 -> {

                continue
            }
            15 -> break
        }
    }
}