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
    fun insertBefore(valueToInsertBefore: Int, value: Int) : String
    {
        //create and insert new node
        val newNode = Node(value)

        if (head?.value == valueToInsertBefore)
        {
            newNode.next = head
            head = newNode
            return "$value is inserted after $valueToInsertBefore successfully!"
        }
        //initialize the traversal
        var current = head
        var previous = head

        while (current?.value != valueToInsertBefore)
        {
            previous = current
            current = current?.next
            if (current == null)
                break
        }
        if (current != null)
        {
            newNode.next = current
            previous?.next = newNode
            return "$value is inserted after $valueToInsertBefore successfully!"
        }
        return "Element not found in the list!"
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
        return if (save == null)
            "Element does not exist!!"
        else
            "Element exists!!"
    }
    fun insertAtSpecificPosition(position : kotlin.Int, value: Int) : String
    {
        //is position node found in the list
        if (position > countNumberOfNodes())
            return "Position not found" // Modify the return message as needed

        //creating newNode as well as initializing it
        val newNode = Node(value)

        //check if position is 1 if then newNode becomes first node
        if (position == 1)
        {
            newNode.next = head?.next
            head = newNode
            return "$value inserted successfully at position $position"
        }

        ////traverse the list until node at position-1 not found
        var save=head
        var j = 1

//        //checking that the position is last position or not
//        if (position == countNumberOfNodes()) //last node
//        {
//            while (j != position-1)
//            {
//                save=save?.next
//                j++
//            }
//            save?.next = newNode
//            return "$value inserted successfully at position $position"
//        }
        while (j != position-1)
        {
            save=save?.next
            j++
        }

        //set new node to given position
        newNode.next = save?.next
        save?.next = newNode

        return "$value inserted successfully at position $position"
    }
    fun deleteFromBeginning () : String
    {
        // Check if the list is empty
        if (head == null)
            return "List is empty. Cannot delete from beginning."

        // Store the current head node
        val deletedNode = head

        // Update the head to point to the next node
        head = head?.next

        // Free the memory of the deleted node (optional)
        deletedNode?.next = null

        return "Successfully deleted node from the beginning."
    }
    fun deleteFromEnd() : String
    {
        if (head == null)
            return "List is empty. Cannot delete from ending."

        //if there is only one node in the list
        if (head?.next == null)
        {
            val x = head?.value
            head=null
            return "$x is deleted from ending of the linked list."
        }

        //traverse the list till second last node is not found
        var save = head

        while (save?.next?.next != null)
            save=save.next

        val x = save?.next?.value

        save?.next = null

        return "$x is deleted from beginning of the linked list."
    }
    fun deleteNodeAfterNode(value: Int) : String
    {
        //checking that linked list is empty or not
        if (head == null)
            return "Linked list is empty."
        //traverse the node until the node is not found
        var save = head
        while (save?.value != value)
        {
            save = save?.next
            if (save == null)
                break
        }
        if (save != null && save.next != null)
        {
            val x = save.next?.value
            save.next = save.next?.next
            return "$x is deleted successfully!"
        }
        //if element not found
        if (save == null)
            return "NO such element is found!"

        //if last node contains value
            return "There is no node after node contains value $value"
    }
    fun deleteParticularValueNode(value: Int) : String
    {
        //checking that linked list is empty or not
        if (head == null)
            return "Linked list is empty."

        //if first node contains value n
        if (head?.value == value)
        {
            val x=head?.value
            head=head?.next
            return "$x is deleted successfully!"
        }

        //traverse the list till node contains value is not found
        var save = head
        var prev = head

        while (save?.value != value)
        {
            prev= save
            save=save?.next
            if (save==null)
                break
        }

        //delete the node to be deleted
        if (save != null)
        {
            val x = save.value
            prev?.next = save.next
            return "$x is deleted successfully!"
        }
        return "Given node not found in the list!"
    }
    fun deleteAtSpecificPosition(pos : kotlin.Int) : String
    {
        //check whether the linked list is empty or not
        if (head == null)
            return "Linked list is empty!"

        //if position not found in the list
        if (pos > countNumberOfNodes())
            return "Invalid position entered!"

        //if 1st node to be deleted
        if (pos == 1)
        {
            val x = head?.value
            var del = head
            del = null
            head=head?.next
            return "$x is deleted successfully from position $pos"
        }

        //traverse the list till (pos-1) not found
        var save = head
        var i=1
        while (i != pos-1)
        {
            save=save?.next
            i++
        }

        //delete the node to be deleted
        var del = save?.next
        del = null
        val x = save?.next?.value

        if (save?.next?.next == null)//last node
            save?.next = null
        else
            save.next = save.next?.next

        return "$x is deleted successfully from position $pos."
    }
    fun deleteEntireList()
    {
        var save = head

        if (head != null)
        {
            while (save != null)
            {
                println(deleteFromBeginning())
                save=head
            }
        }
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
        println("Press 8 = insert a node at a specific position")
        println("Press 9 = delete from the beginning of the list")
        println("Press 10 = delete from the end of the list")
        println("Press 11 = deleting the node after the node that has given value")
        println("Press 12 = deleting the specific node that has given value")
        println("Press 13 = deleting the node at given position")
        println("Press 14 = delete the entire list")
        println("Press 15 = Exit")
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
                println(linkedList1.insertBefore(valueToInsertBefore,value))
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
            8 -> {
                println("Enter position:")
                val pos : Int = newSc.nextInt()
                println("Enter element to insert:")
                val value = newSc.nextInt()
                println(linkedList1.insertAtSpecificPosition(pos,value))
                continue
            }
            9 -> {
                println(linkedList1.deleteFromBeginning())
                continue
            }
            10 -> {
                println(linkedList1.deleteFromEnd())
                continue
            }
            11 -> {
                println("Enter value:")
                val x = newSc.nextInt()
                println(linkedList1.deleteNodeAfterNode(x))
                continue
            }
            12 -> {
                println("Enter value:")
                val x = newSc.nextInt()
                println(linkedList1.deleteParticularValueNode(x))
                continue
            }
            13 -> {
                println("Enter position of the node to be deleted:")
                val x = newSc.nextInt()
                println(linkedList1.deleteAtSpecificPosition(x))
                continue
            }
            14 -> {
                linkedList1.deleteEntireList()
                continue
            }
            15 -> break
        }
    }
    println("-------------------------------------------------------------")
}