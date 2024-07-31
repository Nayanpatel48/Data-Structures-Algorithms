package linkedLists

import java.util.Scanner

//Node2 is the node name given just to avoid error in this package it is just a normal node
class Node2<Int>(var value: Int)//singly
{
    var next: Node2<Int>? = null
}
class LinkedList2<Int>
{
    private var head: Node2<Int>? = null

    fun display()
    {
        if (head == null)
        {
            println("Linked list is empty!")
            return
        }

        //initialize the traversal
        var save = head
        while (save?.next != head)
        {
            print("${save?.value} ->")
            save=save?.next
        }
        //last node printing
        print(save?.value)
        println()
    }
    fun countTotalNodes() : kotlin.Int
    {
        var i = 0
        if (head == null)
            return 0

        //initialize traversal
        var save = head
        while (save?.next != head)
        {
            save=save?.next
            i++
        }
        return i+1
    }
    fun searchNode(value : Int) : String
    {
        if (head == null)
            return "lINKED LIST IS EMPTY!"

        //initialize traversal
        var save = head
        while (save?.value != value)
        {
            save = save?.next
            if (save?.next == head)
                break
        }

        if (save?.value == value || save?.next != head)
            return "KEY FOUND!"
        return "KEY NOT FOUND!"
    }
    fun insertAtBeginning(value : Int) : String
    {
        //creating newNode as well as initializing it
        var newNode = Node2<Int>(value)

        if (head == null)//if linked list is empty
        {
            head = newNode
            newNode.next = head
        }
        else
        {
            //initializing traversal
            var save = head
            while (save?.next != head)
                save=save?.next
            newNode.next = head
            save?.next = newNode
            head = newNode
        }
        return "Value $value is added at the beginning of the linked list!"
    }
    fun insertAtEnding(value : Int) : String
    {
        //creating newNode as well as initializing it
        var newNode = Node2<Int>(value)

        if (head == null)//if linked list is empty
        {
            head = newNode
            newNode.next = head
        }
        else
        {
            //initialize the traversal
            var save = head
            while (save?.next != head)
                save=save?.next
            save?.next = newNode
            newNode.next=head
        }
        return "Value $value is added at the end of the linked list!"
    }
    fun insertAfterNode (value : Int, valueToBeInserted : Int) : String
    {
        //creating newNode as well as initializing it
        var newNode = Node2<Int>(valueToBeInserted)
        //initialize traversal
        var save = head
        while (save?.value != value)
        {
            save=save?.next
            if (save?.next == head)
                break
        }
        if (save?.next != head)
        {
            newNode.next = save?.next
            save?.next=newNode
        }
        else if (save?.value== value)
        {
            insertAtBeginning(valueToBeInserted)
            return "$valueToBeInserted is added after the node containing value $value."
        }
        else
            return "No node found!"
        return "$valueToBeInserted is added after the node containing value $value."
    }
    fun insertBeforeNode (value : Int, valueToBeInserted : Int) : String
    {
        //creating newNode as well as initializing it
        var newNode = Node2<Int>(valueToBeInserted)
        if (head?.value == value)
        {
            insertAtBeginning(valueToBeInserted)
            return "$valueToBeInserted inserted before node containing value $value"
        }
        //initialize traversal
        var save = head
        var prev = head
        while (save?.value != value)
        {
            prev = save
            save = save?.next
            if (save?.next == head)
                break
        }
        if (save?.value == value || save?.next != head)
        {
            newNode.next = prev?.next
            prev?.next=newNode
        }
        else
            return "Node not found!"
        return "$valueToBeInserted inserted before node containing value $value"
    }
    fun insertNodeAtSpecificPos(pos : kotlin.Int, valueToBeInserted: Int) : String
    {
        //creating newNode as well as initializing it
        var newNode = Node2<Int>(valueToBeInserted)
        var i = 0

        if (pos > countTotalNodes())
            return "Position not found!"

        if (pos == 1)
        {
            insertAtBeginning(valueToBeInserted)
            return "Value inserted successfully!"
        }
        //initialize traversal
        var save = head
        while (i != pos-1)
        {
            save = save?.next
            i++
        }
        if (save?.next == head)
        {
            insertAtEnding(valueToBeInserted)
            return "Value inserted successfully!"
        }
        else
        {
            newNode.next = save?.next
            save?.next = newNode
        }
        return "Value inserted successfully!"
    }
    fun deleteFromBeginning() : String
    {
        //check for underflow
        if (head == null)
            return "Underflow->.linked list is empty!"
        //save head data
        val data = head?.value
        //if only one node exists
        if (head?.next == head)
            head == null
        else // there is more than one node in the linked list
        {
            //initialize traversal
            var save = head
            while (save?.next != head)
                save=save?.next
            save?.next = head?.next
            head=head?.next
        }
        return "$data is deleted successfully from beginning!"
    }
    fun deleteFromEnding() : String
    {
        //check for underflow
        if (head == null)
            return "Underflow->.linked list is empty!"

        if (head?.next == head)
        {
            val x = head?.value
            head=null
            return "$x is deleted from ending of the linked list!"
        }
        else
        {
            var save = head
            while (save?.next?.next != head)
                save=save?.next
            val x=save?.next?.value
            save?.next = head
            return "$x is deleted from ending of the linked list!"
        }
    }
    fun deleteAfterNode(nodeValue : Int) : String
    {
        //check for underflow
        if (head == null)
            return "Linked list is empty!"

        //traversing the list till node not found
        var save = head
        while (save?.value != nodeValue)
        {
            save=save?.next
            if (save?.next == head)
                break
        }
//        if (save?.next != head)
//        {
//            val x = save?.next?.value
//            save?.next=save.next?.next
//            return "$x deleted successfully!"
//        }
        if (save?.value==nodeValue)
        {
            val x = deleteFromBeginning()
            return "$x deleted successfully!"
        }
        else
            return "Given node is not found!"
    }
    fun deleteSpecificValueNode(value : Int) : String
    {
        //check for underflow
        if (head == null)
            return "Linked list is empty!"

        if (head?.value == value)
            return "${deleteFromBeginning()} is deleted successfully!"

        //initialize traversal
        var save = head
        var prev = save

        while (save?.value != value)
        {
            prev = save
            save=save?.next
            if (save?.next == head)
                break
        }

        if (save?.next != head)
        {
            val x = save?.value
            prev?.next=save?.next
            return "$x is deleted successfully!"
        }
        else if(save?.value == value)
            return "${deleteFromEnding()} is deleted successfully!"
        else
            return "No node after given node."
    }
}
fun main()
{
    val linkedList2 = LinkedList2<Int>()
    //Scanner created for taking input
    val sc = Scanner(System.`in`)

    //infinite loop
    while (true)
    {
        println("/////////////////////////////////////////////////////////////////////////////////////////////////////")
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
        println("Press 12 = delete the node with specific value")
        println("Press 13 = delete the node at specific position")
        println("Press 14 = exit")
        println("Enter choice:")
        var token = sc.nextInt()
        when (token)
        {
            1 -> {
                linkedList2.display()
                continue
            }
            2 -> {
                println("Total nodes : "+linkedList2.countTotalNodes())
                continue
            }
            3 -> {
                println("Enter value to be searched:")
                val x = readln().toInt()
                println(linkedList2.searchNode(x))
                continue
            }
            4 -> {
                println("Enter value to be inserted at beginning:")
                val x = readln().toInt()
                println(linkedList2.insertAtBeginning(x))
                continue
            }
            5 -> {
                println("Enter value to be inserted at ending:")
                val x = readln().toInt()
                println(linkedList2.insertAtEnding(x))
                continue
            }
            6 -> {
                println("Enter value:")
                val x = readln().toInt()
                println("Enter value to be inserted before $x :")
                val y = readln().toInt()
                println(linkedList2.insertBeforeNode(x,y))
                continue
            }
            7 -> {
                println("Enter value:")
                val x = readln().toInt()
                println("Enter value to be inserted after $x :")
                val y = readln().toInt()
                println(linkedList2.insertAfterNode(x,y))
                continue
            }
            8 -> {
                println("Enter position of node:")
                val x = readln().toInt()
                println("Enter value to be inserted:")
                val y = readln().toInt()
                println(linkedList2.insertNodeAtSpecificPos(x,y))
                continue
            }
            9 -> {
                println(linkedList2.deleteFromBeginning())
                continue
            }
            10 -> {
                println(linkedList2.deleteFromEnding())
                continue
            }
            11 -> {
                println("Enter node value:")
                val x = readln().toInt()
                println(linkedList2.deleteAfterNode(x))
                continue
            }
            12 -> {
                println("Enter node value:")
                val x = readln().toInt()
                println(linkedList2.deleteSpecificValueNode(x))
                continue
            }
            13 -> {

                continue
            }
            14 -> break
        }
    }
}