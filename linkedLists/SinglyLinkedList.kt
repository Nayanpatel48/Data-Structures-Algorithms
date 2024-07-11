package linkedLists

import java.util.Scanner

class Node<Int>(val value: Int)
{
    var next: Node<Int>? = null
}
class LinkedList<Int>
{
    private var head: Node<Int>? = null

    // Add a new node at the beginning of the linked list
    fun prepend(value: Int) : String
    {
        //create an empty node as well as initializing it
        val newNode = Node(value)

        if (head == null)
            head = newNode
        else
        {
            newNode.next = head
            head = newNode
        }
        return  "$value is prepended successfully!"
    }

    // Add a new node to the end of the list
    fun append(value: Int)
    {
        //created an empty node as well as initialized it
        val newNode = Node(value)

        if (head == null)//if least is empty
            head = newNode
        else//if least is not empty
        {
            //initialize traversal
            var current = head

            while (current?.next != null)
                current = current.next

            current?.next = newNode
        }
        println("$value is appended successfully!")
    }

    // Insert a new node after a specific value (assuming values are unique)
    fun insertAfter(valueToInsertAfter: Int, value: Int)
    {
        //create and initialize the new node
        val newNode = Node(value)

        //initialize the traversal
        var current = head

        //traverse the list until the node N not found
        while (current != null)
        {
            if (current.value == valueToInsertAfter)
                break
            current = current.next
        }

        if (current == null)
            println("No such element exists!")
        else
        {
            newNode.next = current.next
            current.next = newNode
        }
        println("$value is inserted after $valueToInsertAfter successfully!")
    }
    fun insertBefore(valueToInsertBefore: Int, value: Int)
    {

    }
    // Print the elements of the linked list
    fun showLinkedList()
    {
        //checking if linked list is empty or not
        if (head == null)
        {
            println("Linked list is empty!")
            return
        }
        //initializing traversal
        var current = head

        //traverse node one by one to print the data
        while (current != null)
        {
            print("${current.value} -> ")
            current = current.next
        }
    }
    fun countNumberOfNodes() : kotlin.Int
    {
        //initialize traversal
        var save = head
        var i=0

        //count the number of nodes in the list
        while (save != null)
        {
            i++
            save=save.next
        }
        //return value
        return i
    }
    fun searchingAnElement(value : Int) : String
    {
        //checking underflow
        if (head == null)
            return "Linked list is empty!!"

        //initialize for a search of an element
        var save = head

        //search for element 'value'
        while (save?.value != value)
        {
            save=save?.next
            if (save == null)
                break
        }

        //is element found in the list or not
        if (save == null)
            return "Element does not exist!!"
        else
            return "Element exists!!"
    }
}

fun main()
{
    val linkedList1 = LinkedList<Int>() // Now using Int for primitive data type
    val newSc = Scanner(System.`in`)

    // Infinite loop
    while (true)
    {
        println("-------------------------------------------------------------")
        println("Press 1 = Inserting At End of the list")
        println("Press 2 = Inserting At the Beginning of the list")
        println("Press 3 = Display LinkedList")
        println("Press 4 = Insert after given node value")
        println("Press 5 = Insert before given node value")
        println("Press 6 = count total number of nodes")
        println("Press 7 = search for value")
        println("Press 8 = Exit")
        var choice = newSc.nextInt()

        when (choice)
        {
            1 -> {
                println("Enter element:")
                val value = newSc.nextInt()
                linkedList1.append(value)
                continue
            }
            2 -> {
                println("Enter element:")
                val value = newSc.nextInt()
                println(linkedList1.prepend(value))
                continue
            }
            3 -> {
                linkedList1.showLinkedList()
                continue
            }
            4 -> {
                println("Enter value to insert after:")
                val valueToInsertAfter = newSc.nextInt()
                println("Enter element to insert:")
                val value = newSc.nextInt()
                linkedList1.insertAfter(valueToInsertAfter, value)
                continue
            }
            5 -> {
                println("Enter value to insert before:")
                val valueToInsertBefore = newSc.nextInt()
                println("Enter element to insert:")
                val value = newSc.nextInt()
                linkedList1.insertBefore(valueToInsertBefore,value)
                continue
            }
            6 -> {
                println(linkedList1.countNumberOfNodes())
                continue
            }
            7 -> {
                println("Enter value to be searched:")
                val value = newSc.nextInt()
                println(linkedList1.searchingAnElement(value))
            }
            8 -> break
        }
    }
    println("-------------------------------------------------------------")
}