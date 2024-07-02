import java.util.*;
public class Arrays{
    public int linearSearch(int[] Array, int target){
        for(int i=0; i<Array.length;i++){
            if(Array[i] == target){
                System.out.println("position of target is:"+i);
                return i ;
            }
        }
        System.out.println("target not found.");
        return -1 ;
        
        
    }
    public int binarySearch(int[] Array, int target){
        int left = 0 ;
        int right = Array.length - 1 ;
        
        while(left<=right){
            int mid = left + (right-left)/2 ;       // take floor if it is giving odd. 3.5 -> 3
            if(Array[mid] == target){
                System.out.println("position of target is:"+mid);
                return mid ;
            } else if(Array[mid]<target) {
                left = mid + 1 ;
            } else{
                right = mid - 1 ;
            }
            System.out.println("target not found.");
        }
        
        return -1 ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements to insert:");
        int n = sc.nextInt();
        int[] Array = new int[n];
        System.out.println("Enter elements");
        for(int i=0; i<Array.length;i++){
            Array[i] = sc.nextInt();
        }
        System.out.println("User input:"+Array.toString());  // change file name to print this. Arrays is a module to import. 
        System.out.println("enter element to search:");
        int target = sc.nextInt();
        Arrays obj = new Arrays();
        System.out.println("output by linearSearch:"+obj.linearSearch(Array, target));
        System.out.println("output by binarySearch:"+obj.binarySearch(Array, target));
        
    }
    
}