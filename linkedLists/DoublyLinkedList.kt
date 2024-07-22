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
    fun insertAtSpecificPosition(pos : kotlin.Int, valueToBeInserted : Int) : String
    {
        //create new node as well as initializing data fields
        var newNode = Node1(valueToBeInserted)
        newNode.prev=null
        newNode.next=null

        //position indicator
        var count=1
        //checking validation of position
        if (pos>totalNodes())
            return "Position not found"

        //if position is 1
        if (pos==1)
        {
            newNode.next=head
            head?.prev= newNode
            head=newNode
            return "$valueToBeInserted inserted successfully at position $pos"
        }

        //initialize traversal
        var save = head

        while (count != pos-1)
        {
            save=save?.next
            count++
        }
        newNode.next=save?.next
        newNode.prev=save
        save?.next?.prev=newNode
        save?.next=newNode
        return "$valueToBeInserted inserted successfully at position $pos"
    }
    fun deleteFromBeginning() : String
    {
        if (head == null)
            return "Linked list is empty!!"

        val x = head?.value

        if (head?.next == null)//there is only one element in the list
            head=null
        else
        {
            head=head?.next
            head?.prev=null
        }
        return "$x deleted from beginning successfully!!"
    }
    fun deleteFromEnding() : String
    {
        //checking that linked list is empty or not
        if (head == null)
            return "Linked list is empty!"

        //there is only one node exists in the linked list
        if (head?.next == null)
        {
            val x= head?.value
            head = null
            return "$x value is deleted from the ending!"
        }

        //initialize traversal
        var save = head
        while (save?.next != null)
            save=save.next

        val x = save?.value
        save?.prev?.next=null
        return "$x value is deleted from the ending!"
    }
    fun deleteAfterNode(value: Int) : String
    {
        if (head == null)
            return "Linked list is empty!!"

        //traverse list till the node contains value is not found
        var save = head
        while (save?.value != value)
        {
            save=save?.next
            if (save==null)
                break
        }

        if (save!=null && save.next != null)
        {
            val x = save.next?.value
            save.next?.next?.prev = save
            save.next = save.next?.next
            return "$x is deleted after node containing value $value"
        }
        else if (save == null)
            return "Given node not found!"
        else
            return "NO node after given node!!"
    }
    fun deleteBeforeNode(value: Int) : String
    {
        if (head == null) // checking whether linked list is empty or not
            return "The linked list is empty!!"

        //traversing the list
        var save = head
        while (save?.value != value)
        {
            save=save?.next
            if (save == null)
                break
        }

        if (save != null && save.prev != null)
        {
            val x= save.prev?.value
            save.prev?.prev?.next=save
            save.prev = save.prev?.prev
            return "Node with value $x is deleted before node $value"
        }
        else if (save == null)
            return "Given node not found!"
        else
            return "NO node before the given node!"
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
        println("Press 10 = delete after a given node")
        println("Press 11 = delete before a given node")
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
                println("Enter position:")
                var x = readln().toInt()
                println("Enter value to be inserted :")
                var y = readln().toInt()
                println(linkedList1.insertAtSpecificPosition(x,y))
                continue
            }
            8 -> {
                println(linkedList1.deleteFromBeginning())
                continue
            }
            9 -> {
                println(linkedList1.deleteFromEnding())
                continue
            }
            10 -> {
                println("Enter value after which you want to delete:")
                val y = readln().toInt()
                println(linkedList1.deleteAfterNode(y))
                continue
            }
            11 -> {
                println("Enter value before which you want to delete:")
                val y = readln().toInt()
                println(linkedList1.deleteBeforeNode(y))
                continue
            }
            12 -> break
        }
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    }
}