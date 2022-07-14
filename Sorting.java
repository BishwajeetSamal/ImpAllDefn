Sorting
=======
Sorting is the process of arranging the data in some logical order. In case of numeric values, logical order may
be ascending or descending order. Order for alphanumeric values, it will be in dictionary order.

Bubble Sorting
=============
Bubble sort, also reffered to as sinking sort, is a comparison based algorithm i.e. comparing each pair of adjacent
items and swapping them if they are in the wrong order. The pass through the list is repeated until no swaps are 
needed, which indicates that the kist is sorted.




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