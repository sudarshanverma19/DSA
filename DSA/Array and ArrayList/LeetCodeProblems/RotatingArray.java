package LeetCodeProblems;
// rotate an array by D places left
public class RotatingArray {
    static void reverse(int arr[],int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotateL(int arr[], int k){
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
        for(int i=0 ; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        //System.out.println(Array.toString(arr));     -> why this is not working
    }

    // for right rotation also we cann use same logic
    public static void rotateR(int arr[], int k){
        reverse(arr,arr.length-k,arr.length-1);
        reverse(arr,0,arr.length-k-1);
        reverse(arr,0,arr.length-1);
        for(int i=0 ; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        rotateL(arr,3);
        int arr1[] = {1,2,3,4,5,6,7};
        rotateR(arr1, 3);
    }
}
