package LeetCodeProblems;

/*Rotation of an array int Sorted Manner . 
 * Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
*/
public class Node{
    int data;
    Node next ;
    public Node(int data){
        this.data = data ;
        this.next = null;
    }
}
class CheckRotatedSortedArray {
    public boolean check(int[] nums) {
        Node head = arrToLL(nums);
        return isRotatedSorted(head,nums.length);
    }
    public boolean isRotatedSorted(Node head, int length){
        if(head==null){
            return true ;
        }
        int breakpoint = 0;
        Node current = head ;
        for(int i=0; i<length ;i++){
            if(current.data > current.next.data){
                breakpoint++ ;
            }
            current = current.next ;
        }
        return breakpoint <= 1;
    }
    public Node arrToLL(int nums[]){
        if(nums==null || nums.length==0){
            return null ;
        }
        Node head = new Node(nums[0]);
        Node currNode = head;
        for(int i=1;i<nums.length;i++){
            currNode.next = new Node(nums[i]);
            currNode = currNode.next ;
        }
        currNode.next = head ;
        return head ;
    }
}

// optimal solution

public class CheckRotatedSortedArray {
    public static boolean isRotatedSortedArray(int[] nums) {
        int n = nums.length;
        int breakCount = 0;

        // Count the number of breaks in the array's order
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                breakCount++;
            }
        }

        // If there is more than one break point, it is not a rotated sorted array
        return breakCount <= 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {2, 1, 3, 4};
        int[] nums3 = {1, 2, 3};

        System.out.println(isRotatedSortedArray(nums1)); // Output: true
        System.out.println(isRotatedSortedArray(nums2)); // Output: false
        System.out.println(isRotatedSortedArray(nums3)); // Output: true
    }
}

