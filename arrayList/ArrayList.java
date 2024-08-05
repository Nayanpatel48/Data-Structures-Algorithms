package arrayList;

public class ArrayList
{
    public static void main(String[] args)
    {
        //created an arraylist that stores String type values
        //ypu can create any type of collection by placing datatype inside ArrayList<__>
        java.util.ArrayList<String> collection1 = new java.util.ArrayList<>();

        //adding new elements inside collection1
        collection1.add("Nayan");
        collection1.add("Harshil");
        collection1.add("Akhil");
        collection1.add("DC");
        collection1.add("xyz");
        System.out.println(collection1);

        //adding new element at a specific index
        collection1.add(2,"Jatin");
        System.out.println(collection1);

        //determining size of arrayList
        System.out.println(collection1.size());

        //checking whether the list contains the specific element or not
        System.out.println(collection1.contains("Harshil"));
        System.out.println(collection1.contains("xyz"));

        //making clone ArrayList
        //here we copied entire collection1 into collection1Clone ArrayList then we added the element
        java.util.ArrayList<String> collection2 = new java.util.ArrayList<>();
        //adding new elements inside collection2
        collection2.add("Spider");
        collection2.add("Deadpool");
        collection2.add("Marvel");
        collection2.add("DC");
        collection2.add("xyz");
        System.out.println("Collection2 data:"+collection2);


        @SuppressWarnings("unchecked")
        java.util.ArrayList<String> collection1Clone = (java.util.ArrayList<String>)(collection1.clone());
        collection1Clone.addAll(collection2);
        System.out.println("Collection 1 clone:"+collection1Clone);

        //overlapping elements from collection 1 and collection 2 will not be removed
        collection1.retainAll(collection2);
        System.out.println("After performing retainAll on collection 1:"+collection1);

        //adding elements to perform .removeAll()
        collection1.add("Nayan");
        collection1.add("Harshil");
        collection1.add("Akhil");
        collection1.add("DC");
        collection1.add("xyz");
        collection2.add("Spider");
        collection2.add("Deadpool");
        collection2.add("Marvel");
        collection2.add("DC");
        collection2.add("xyz");
        //Element in collection 1 but not in collection 2
        collection1.removeAll(collection2);
        System.out.println("Element in collection 1 but not in collection 2:"+collection1);

        java.util.Collection<String> collection3 = new java.util.ArrayList<>();
        collection3.add("New York");
        collection3.add("America");
        collection3.add("Russia");
        System.out.println("The elements inside collection3 are:"+collection3);
    }
}