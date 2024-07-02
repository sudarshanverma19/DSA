import java.util.* ;
import java.util.Arrays;
public class PracticeArray{
    //Find the Maximum and Minimum Elements:
//Write a function that takes an array of integers and returns the maximum and minimum elements in the array.
    public void greatestElement(){
        int[] arr = {10, 20, 30, 40, 50};
        int max = arr[0];            // max is pointing at 10.
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            } else{
                continue;
            }
        }
        System.out.println("max number is:" + max);
    }
//Sum of Array Elements:
//Write a function that returns the sum of all elements in a given array.
    public void sumOfElements(){
        int[] arr = {10, 20, 30, 40, 50};
        int sum = 0 ;
        for(int i=0;i<arr.length;i++){
            sum = sum+arr[i] ;
        }
        System.out.println("sum of elements is:"+sum);
    }
    /*Reverse an Array:
    Write a function that takes an array and returns a new array with elements in reverse order. */
    public void revArray(){
        int[] arr = {10, 20, 30, 40, 50};
        int head = arr[0];
        int tail = arr.length-1;
        while(head<tail){
            int temp = arr[head] ;
            arr[head] = arr[tail] ;
            arr[tail] = temp ;
            head++ ;
            tail-- ;
        }
        System.out.println("reversed array is: ");
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }                
    }

    /*Find the Second Largest Element:
Write a function that finds the second largest element in an array. */
    public void second_largest(){
        int largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE ;
        int[] arr = {10, 20, 30, 40, 50};
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                second_largest = largest ;
                largest = arr[i] ;
            } else if(arr[i]>second_largest && arr[i]<largest){
                second_largest = arr[i] ;
            } else if(second_largest == Integer.MIN_VALUE){
                System.out.println("second-largest not found in array.");
            }
        }
        System.out.println("second largest element is :"+second_largest);
    }

    //Count Even and Odd Numbers:
//Write a function that takes an array and counts the number of even and odd numbers.
    public void countEvenOdd(){
        int evenCount = 0;
        int oddCount = 0 ;
        int[] arr = {10, 20, 30, 40, 50};
        for(int i=0; i<arr.length;i++){
            if(arr[i]%2 == 0){
                evenCount ++ ;
            } else if(arr[i]%2 == 1){
                oddCount ++ ;
            } else {
                System.out.println("please check array and give integers only.");
            }
        }
        System.out.println("even count is: "+evenCount);
        System.out.println("odd count is: "+oddCount);
    }
    /*Remove Duplicates from Sorted Array:
Write a function that removes duplicates from a sorted array and returns the new length of the array. */
public void findDuplicates() {              // not efficient; use sorting technique here to make it more efficient .
    int[] arr = {1, 2, 2, 3, 3};
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[i] == arr[j]) {
                System.out.println("Duplicate found at index " + i + " : " + arr[i]);
                break;  // Break the inner loop once a duplicate is found to avoid multiple prints
            }
        }
    }
}
public void findDuplicatesOptimal(){
    int[] arr = {1, 2, 2, 3, 3};
    Arrays.sort(arr);
    for(int i=1; i<arr.length; i++){
        if(arr[i]==arr[i-1]){
            System.out.println("duplicate found at: "+ i);
        }
    }
}
public void removeDuplicates(){
    int[] arr = {1,2,2,3,3,3};
    int uniqueIndex = 0 ;
    int[] newArr = new int[arr.length];
    for(int i=0;i<arr.length;i++){
        boolean isDuplicate = false ;
        for(int j=0;j< i; j++){          // since it is checking its current element with all previous elements, T.C is O(n^2), S.C is O(1)
            if(arr[i] == arr[j]){         // instead sort it(O(nlogn)) and check with prev. element O(n), so T.C is O(nlogn) and S.C is O(1).
                isDuplicate = true ;
                break ;
            }
        }
        if(!isDuplicate){
            newArr[uniqueIndex++] = arr[i];      // ye value 0th index me store ho jayegi and then index badh jayega.
        }
    }
    System.out.println("new array is:");
    for(int i=0; i<uniqueIndex; i++){        
        System.out.print(newArr[i]+" ");
    }
}

public void removeDuplicateOptimal(){
    int[] arr = {1,2,2,3,3,3};
    int[] newArr = new int[arr.length];
    int uniqueIndex = 0; 
    Arrays.sort(arr);  // T.C is O(nlogn)
    
    for(int i =1 ;i<arr.length ;i++){
        boolean isDuplicate = false ;
        if(arr[i] == arr[i-1]){
            isDuplicate = true ;
            break;
        }
        if(!isDuplicate){
            newArr[uniqueIndex++] = arr[i];
        }
    }
    for(int i= 0; i<newArr.length ;i++){
        System.out.println("array with unique index: ");
        System.out.println(newArr[i]+" ");
    }
}

/*Rotate Array:
Write a function that rotates an array to the right by k steps. */


/*Merge Two Sorted Arrays:
Write a function that merges two sorted arrays into a single sorted array. */


/*Find the Intersection of Two Arrays:
Write a function that returns the intersection of two arrays.*/


/*Subarray with Given Sum:
Write a function that finds a continuous subarray which adds up to a given number. */


/*Find the Missing Number:
Write a function that finds the missing number in an array containing n distinct numbers taken from the range 0 to n. */



    public static void main(String[] args) {
        PracticeArray obj = new PracticeArray();
        obj.greatestElement();
        obj.sumOfElements();
        obj.revArray();
        obj.second_largest();
        obj.countEvenOdd();
        obj.findDuplicates();
        obj.removeDuplicates();
        
    }
}
