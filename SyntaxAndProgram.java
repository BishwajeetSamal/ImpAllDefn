											🔥🔥Collections🔥🔥
											===================

*1. ArrayList //Elements in an ArrayList are actually objects. To use other types, such as int, you must specify 
=============
//an equivalent wrapper class: Integer
//For other primitive types, use: Boolean for boolean, Character for char, Double for double, etc.

//main method class making public is not mandatory
public class Test{
	ArrayList<Integer> arr = new ArrayList<>(); // this  is the feature of Java 7
	ArrayList<Integer> arr = new ArrayList<Integer>();
	ArrayList<String> str = new ArrayList<String>();
	ArrayList<String> str = new ArrayList<>();
	List<String> str = new ArrayList<String>();
	List<String> str = new ArrayList<String>();
	List<Integer> intArr = new ArrayList<>();
	List<Employee> intArr = new ArrayList<>();
	List list = new ArrayList(); //we can have an empty arraylist as well as can pass the collection to it.
}

1. to add elements to the ArrayList, use the add() method
arr.add("Bishwajeet");
arr.add(34);
arr.addAll(Collection c);
arr.remove(Object o);
arr.removeAll(Collection c);
arr.contains(Object o);
arr.containsAll(Collection c);
arr.isEmpty();
Object[] toArray();
Iterator iterator();


2. Access an Item
arr.get(0); //0 is the index number

3. Change an Item
arr.set(0,"Samal"); //Set the element to the specified index.

4. Remove an Item
arr.remove(0); //Remove the element from the specified index.

5.To remove all the elements in the ArrayList, use the clear() method
arr.clear();

6.ArrayList Size
arr.size();

7.For Loop
---------
 for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
    }

 8. ArrayList with the for-each loop
 -------------------------------------
 for (String i : arr) {
      System.out.println(i);
    }

9.Sort an ArrayList
-------------------
Collections.sort(cars);  // Sort cars
 for (String i : cars) {
      System.out.println(i); //Print all the cars one by one
    }

--------------------------------------------------------------------------------------
*2. Java LinkedList
====================
 The LinkedList class is almost identical to the ArrayList.
 LinkedList<Integer> arr = new LinkedList<>(); // this  is the feature of Java 7
	LinkedList<Integer> arr = new LinkedList<Integer>();
	LinkedList<String> str = new LinkedList<String>();
	LinkedList<String> str = new LinkedList<>();
	List<String> str = new LinkedList<String>();
	List<String> str = new LinkedList<String>();
	List<Integer> intArr = new LinkedList<>();

The LinkedList class is a collection which can contain many objects of the same type.

The LinkedList class has all of the same methods as the ArrayList class because they both implement the List 
interface. This means that you can add items, change items, remove items and clear the list in the same way.

 LinkedList<String> cars = new LinkedList<String>();
1. to add elements to the ArrayList, use the add() method
cars.add("BMW");
cars.add("Maruti");

How the ArrayList works
-------------------------
The ArrayList class has a regular array inside it. When an element is added, it is placed into the array. 
If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.

How the LinkedList works
-------------------------
The LinkedList stores its items in "containers." The list has a link to the first container and each container has
a link to the next container in the list. To add an element to the list, the element is placed into a new 
container and that container is linked to one of the other containers in the list.

LinkedList Methods  //All the methods of the arraylist is applicable to the linked list
-------------------
addFirst() -- Adds an item to the beginning of the list.
addLast() -- Add an item to the end of the list.
removeFirst() -- Remove an item from the beginning of the list.
removeLast() -- Remove an item from the end of the list.
getFirst() -- Get the item at the beginning of the list
getLast() -- Get the item at the end of the list.


*default capacity of ArrayList is 10.



import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

 Ques1. Store the data inside LinkedList of Java Collection 
 ==========================================================
---------------------------------------------------------------------------------------------------
//0,1,2,3,4,5,11,12,13,14,21,22,23,24,33,31,32,41,43,45,46,55,56,54,65,64,63,76,78,87,89,90,91,100
public class SaveToLinkedList {
    //Arrays.asList(a); is used to pass whole array to the ArrayList or LinkedList
    public static void main(String []args){
        Integer arrList[] =  new Integer[] {0,1,2,3,4,5,11,12,13,14,21,22,23,24,33,31,32,41,43,45,46,55,56,54,65,64,63,76,78,87,89,90,91,100};
        LinkedList<Integer> arrayList = new LinkedList<>(Arrays.asList(arrList));
        System.out.println(arrayList);
        System.out.println(arrayList.getLast());
        
    }
}

Output
=======
[0, 1, 2, 3, 4, 5, 11, 12, 13, 14, 21, 22, 23, 24, 33, 31, 32, 41, 43, 45, 46, 55, 56, 54, 65, 64, 63, 76, 78, 87, 89, 90, 91, 100]
100
-----------------------------------------------------------------------------------------------------

Ques2.Implement the logic in Java8 to sort the data in descending order
=========================================================================
----------------------------------------------------------------------------
 Collections.reverse()
The Collections class in Java provides a static method to reverse the order of elements in a specified list.
 // Collections.reverse(arrayList); //It will reverse the linkedList

 // Collections.sort(arrayList,Collections.reverseOrder()); //It is also helpful to sort the linked list

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Implement the logic in Java8 to sort the data in descending order

//0,1,2,3,4,5,11,12,13,14,21,22,23,24,33,31,32,41,43,45,46,55,56,54,65,64,63,76,78,87,89,90,91,100
public class SaveToLinkedList {
    //Arrays.asList(a); is used to pass whole array to the ArrayList or LinkedList
    public static void main(String []args){
        Integer arrList[] =  new Integer[] {0,1,2,3,4,5,11,12,13,14,21,22,23,24,33,31,32,41,43,45,46,55,56,54,65,64,63,76,78,87,89,90,91,100};
        LinkedList<Integer> arrayList = new LinkedList<Integer>(Arrays.asList(arrList));
        Collections.sort(arrayList,Collections.reverseOrder());
        System.out.println(arrayList);
        
    }
}
Output
-----
100, 91, 90, 89, 87, 78, 76, 65, 64, 63, 56, 55, 54, 46, 45, 43, 41, 33, 32, 31, 24, 23, 22, 21, 14, 13, 12, 11, 5, 4, 3, 2, 1, 0]
---------------------------------------------------------------------------------

1.With the help of the reverseOrder() method to reverse the original sorting order and return Comparator.
This method is an overloaded method.
 2.The two flavors are available of this method first reverseOrder() and second, reverseOrder(Comparator c).This 
 reverseOrder() does not take any argument of the method and return Comparator and this method is applicable 
 for the natural order of reversing that implement the Comparable interface.
3.This reverseOrder(Comparator) takes only one argument of the method and return Comparator and this method is 
applicable for the order of reversing of the given Comparator.
4.The return type of this method is Comparator so it returns Comparator.

public static Comparator reverseOrder()
public static Comparator reverseOrder(Comparator comp)

Java Collections.reverseOrder
------------------------------
By default, Collection.sort performs the sorting in ascending order. 
If we want to sort the elements in reverse order we could use following methods:
//public static <T> Comparator<T> reverseOrder()
1.reverseOrder(): Returns a Comparator that imposes the reverse of natural ordering of elements of the collection.
2.reverseOrder(Comparator cmp): Returns a Comparator that imposes reverse ordering of the specified comparator.

Ques3. Traverse in forward and reverse direction  //A ListIterator can be used to traverse the elements in the
================================================//forward direction as well as the reverse direction in a LinkedList.


        public class SaveToLinkedList {
    //Arrays.asList(a); is used to pass whole array to the ArrayList or LinkedList
    public static void main(String []args){
        Integer arrList[] =  new Integer[] {0,1,2,3,4,5,11,12,13,14,21,22,23,24,33,31,32,41,43,45,46,55,56,54,65,64,63,76,78,87,89,90,91,100};
        LinkedList<Integer> arrayList = new LinkedList<Integer>(Arrays.asList(arrList));
        Collections.sort(arrayList,Collections.reverseOrder());
        for(Integer i : arrayList){
            System.out.println(i);
        }
        System.out.println(arrayList);
        
    }
}
  OR
//Reverse Traversal
  public class SaveToLinkedList {
    //Arrays.asList(a); is used to pass whole array to the ArrayList or LinkedList
    public static void main(String []args){
        Integer arrList[] =  new Integer[] {0,1,2,3,4,5,11,12,13,14,21,22,23,24,33,31,32,41,43,45,46,55,56,54,65,64,63,76,78,87,89,90,91,100};
        LinkedList<Integer> arrayList = new LinkedList<Integer>(Arrays.asList(arrList));
        ListIterator<Integer> list_iterator = arrayList.listIterator(arrayList.size());
        while (list_iterator.hasPrevious()) {
            System.out.println(list_iterator.previous());
        }
       
        
    }
}

Ques4.Implement the logic in Java to filter out the data between 12 to 64 use Stream API
==========================================================================================


