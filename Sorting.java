Sorting
=======
Sorting is the process of arranging the data in some logical order. In case of numeric values, logical order may
be ascending or descending order. Order for alphanumeric values, it will be in dictionary order.

Bubble Sorting
=============
Bubble sort, also reffered to as sinking sort, is a comparison based algorithm i.e. comparing each pair of adjacent
items and swapping them if they are in the wrong order. The pass through the list is repeated until no swaps are 
needed, which indicates that the kist is sorted.

Bubble Sort Program
====================
import java.util.Arrays;

public class BubbleSort {
    public static void main(String []args){
        int[] arr = new int[]{12,54,32,11,77,88,9,69};
        int temp;
    for(int round=1;round<arr.length-1;round++){
            for(int i=0;i<arr.length-round;i++){
               if(arr[i]>arr[i+1]){
                 temp=arr[i];
                arr[i] = arr[i+1];
                arr[i+1]=temp;
               }
            }
        }
                //show all elements for each element
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }

        //show whole array
        System.out.println(Arrays.toString(arr));
    }
}
Output
------
[9, 11, 12, 32, 54, 69, 77, 88]
-----------------------------------------------------------------------------------------------------------------
Insertion Sort
===============
We insert the element into the exact position.
It is less effective than Quick Sort, Merge Sort and Heap Sort.
Step1 -> Start with second position. Put it into temp variable.
temp=1;



import java.util.Arrays;

public class InsertionSort {
    public static void main(String []args){
        int[] arr = new int[]{12,54,32,11,77,88,9,69};
        int j;
    for(int i=1;i<arr.length;i++){
        int temp=arr[i];
        j=i;
            while (j>0 && arr[j-1]>temp) {
                arr[j]=arr[j-1];
                j=j-1;
            }
            arr[j]=temp;
        }
        //show whole array
        System.out.println(Arrays.toString(arr));
    }
}

Output
------
[9, 11, 12, 32, 54, 69, 77, 88]
-----------------------------------------------------------------------------------------------------------------
SELECTION SORT
==============
Round/Passes -  In every round just pick the smallest element and swap.Whenever size of array,List or vector is less
in size then use it.


import java.util.Arrays;

public class SelectionSort {
    public static void main(String []args){
        int[] arr = new int[]{12,54,32,11,77,88,9,69};
        for(int round=0;round<arr.length-1;round++){
            int minIndex = round;
            for(int j=round+1;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }   
            }
            swap(round,minIndex,arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int round,int minIndex,int[] arr){
        int temp=arr[round];
        arr[round]=arr[minIndex];
        arr[minIndex]=temp;
    }
}

Output
======
[9, 11, 12, 32, 54, 69, 77, 88]

-----------------------------------------------------------------------------------------------------------------
MERGE SORT
==========
It basically follows divide and conquer algorithm.
1. Divide the unsorted list into n sublists, each containing one element.
2. Take adjacent pairs of two singleton lists and merge them to form a list of 2 elements. n will now 
convert into n/2 lists of size 2.
3. Repeat the process till a single sorted list of obtained.



-----------------------------------------------------------------------------------------------------------------
Palindrome check until you get the Palindrome. If number is not palindrome then add the original number with its
reverse number and check again for palindrome..
/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
		int num=153;
		int temp=num;
		int tempNum=0;
		
        checkPalindrome(num,tempNum);
	}
	
	//recursion
	public static void checkPalindrome(int temp,int tempNum){
	    int temp1=temp;
	    while(temp1>0){
		    tempNum = tempNum*10+temp1%10;
		    temp1=temp1/10;
		}
	
			if(temp==tempNum){
		   System.out.println(temp+" is Palindrome");
		   
		   
		}else{
		    int getVal = temp+tempNum;
		    checkPalindrome(getVal,0);
		    
		}
	}
}
-----------------------------------------------------------------------------------------------------------------

