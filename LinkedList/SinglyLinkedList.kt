package LinkedList
import java.util.Scanner

class Node<T>(val value: T){
    var next:Node<T>? = null
}
class LinkedList<T>{
    private var head: Node<T>? = null

    // add a new node to the end of the list
    fun append(value: T)
    {
        val newNode = Node(value)
        if(head == null)
        {
            head = newNode
        }
        else {
            var current = head
            while(current?.next != null)
            {
                current = current.next
            }
            current?.next = newNode
        }
    }
    // Print the elements of the linked list
    fun showLinkedList() {
        var current = head
        while (current!=null)
        {
            print("${current.value} -> ")
            current = current.next
        }
        println("null")
    }
    fun remove(value: T)
    {
        var current = head
        var previous: Node<T>? = null
        // Traverse the list to find the node with the specified value
        while (current!=null && current.value !=value)
        {
            previous = current
            current = current.next
        }
        // if value is not found
        if(current == null) {return}

        // update the ref.
        if(previous ==null){
            head = current.next}
        else{
            previous.next = current.next
        }
    }
}
fun main() {
    val linkedList = LinkedList<Int>()

//creating a scanner
    val reader = Scanner(System.`in`)

    println("Enter 4 elements:")
// adding elements to the linked list
    linkedList.append(reader.nextInt())
    linkedList.append(reader.nextInt())
    linkedList.append(reader.nextInt())
    linkedList.append(reader.nextInt())

// printing the linked list
    println("Linked List:")
    linkedList.showLinkedList()

    println("Enter element to be deleted:")
// Remove element with value 89
    linkedList.remove(reader.nextInt())
    println("After Removing")
    linkedList.showLinkedList()
}