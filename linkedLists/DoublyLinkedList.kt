package linkedLists

import java.util.Scanner

//Node1 is the node name given just to avoid error in this package it is just a normal node
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
    fun insertAtBeginning(value : Int) : String
    {
        //create an empty node as well as initializing it
        var newNode = Node1(value)

        //initializing newNode's fields
        newNode.value=value
        newNode.next=null
        newNode.prev=null

        if (head != null)
        {
            newNode.next=head
            head?.prev=newNode
            head=newNode
            return "$value inserted at beginning successfully!!"
        }
        head=newNode
        return "$value inserted at beginning successfully!!"
    }
    fun insertAtEnding(value : Int) : String
    {
        //create an empty node as well as initializing it
        var newNode = Node1(value)

        //initializing newNode's fields
        newNode.value=value
        newNode.next=null
        newNode.prev=null

        if (head==null)
        {
            head=newNode
            return "$value is added at ending of list successfully!"
        }
        else
        {
            var save = head
            while (save?.next != null)
                save=save.next
            save?.next=newNode
            newNode.prev=save
        }
        return "$value is added at ending of list successfully!"
    }
    fun insertAfter(value : Int, valueToBeInserted : Int) : String
    {
        //create and initializing new node
        var newNode = Node1(valueToBeInserted)

        newNode.prev=null
        newNode.next=null

        //traversing till the value is not found
        var save = head
        while (save?.value != value)
        {
            save=save?.next
            if (save==null)
                break
        }

        if (save != null) // if value found
        {
            newNode.next = save.next
            newNode.prev=save
            save.next?.prev= newNode
            save.next=newNode
            return "$valueToBeInserted is inserted after $value successfully!"
        }
        else
            return "Node not found"
    }
    fun insertBefore(value : Int, valueToBeInserted : Int) : String
    {
        //create and initializing new node
        var newNode = Node1(valueToBeInserted)

        newNode.prev=null
        newNode.next=null

        //if value is found in first node
        if (head?.value == valueToBeInserted)
        {
            newNode.next = head
            head!!.prev= newNode
            head=newNode
            return "$valueToBeInserted is inserted before $value successfully!!"
        }

        //traversing linked list till the node containing value not found
        var save = head
        while (save?.value != value)
        {
            save=save?.next
            if (save==null)
                break
        }
        if(save!=null)
        {
            newNode.next=save
            newNode.prev=save.prev
            save.prev?.next=newNode
            save.prev=newNode
            return "$valueToBeInserted is inserted before $value successfully!!"
        }
        else
            return "Node not found!"
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
        println("Press 5 = insert after given node")
        println("Press 6 = insert before given node")
        println("Press 7 = insert at specific location")
        println("Press 8 = delete from beginning")
        println("Press 9 = delete from ending")
        println("Press 10 = delete the specific node")
        println("Press 11 = delete after a given node")
        println("Press 12 = exit")
        println("Enter choice:")
        var token = sc.nextInt()
        when (token)
        {
            1 -> {
                linkedList1.display()
                println()
                continue
            }
            2 -> {
                println(linkedList1.totalNodes())
                continue
            }
            3 -> {
                println("Enter value to be inserted:")
                var x = sc.nextInt()
                println(linkedList1.insertAtBeginning(x))
                continue
            }
            4 -> {
                println("Enter value to be inserted:")
                var x = sc.nextInt()
                println(linkedList1.insertAtEnding(x))
                continue
            }
            5 -> {
                println("Enter value:")
                var x = readln().toInt()
                println("Enter value to be inserted after $x :")
                var y = readln().toInt()
                println(linkedList1.insertAfter(x,y))
                continue
            }
            6 -> {
                println("Enter value:")
                var x = readln().toInt()
                println("Enter value to be inserted before $x :")
                var y = readln().toInt()
                println(linkedList1.insertBefore(x,y))
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
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    }
}