package LeetCodeProblems;
// Aim is to move all the 0's at the end of array.
public class ZerosAtEnd {
    static void moveZeros(int arr[]){
        int[] temp = new int[arr.length];
        int count = 0;
        int j = 0; 
        for(int i=0; i<arr.length;i++){
            if(arr[i] != 0){
                 temp[j] = arr[i];
                 j++ ;
            } else {
                count++;
                continue ;
            }
        }
        while(count>0){
            temp[j] = 0;
            j++;
            count--;
        }
        for(int i=0; i<temp.length;i++){
            System.out.print(temp[i]+" ");
        }
    }

    // optimal solution : not creating different array and using 2 pointer approach.
    static void moveZerosOptimal(int arr[]){
        for(int i=0; i<arr.length-1;i++){
            if(arr[i]==0){
                int j = i;
                i++ ;
                if(arr[i]!=0){
                    swap(arr,i,j); 
                }
                
            }
        }
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void swap(int arr[] ,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,3,12};
        moveZeros(arr);
        System.out.println();
        moveZerosOptimal(arr);
    }
}
