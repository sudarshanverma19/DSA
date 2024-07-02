/* Algorithm
 * partition()
 * {
 * for(j=low;j<high;j++){
 * if(arr[j]<pivot){
 * i++;
 * swap(arr[i],arr[j]);
 * }
 * }
 * swap(arr[i],arr[high])
 * return i+1
 * }
 */
public class Quick{

    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pi = partition(arr, low, high);
            
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);

        }
    }
        public static int partition(int[] arr, int low, int high) {
        // TODO Auto-generated method stub
        int pivot = arr[high];
        int i = (low-1); // index of smaller element

        for(int j = low ; j<high;j++){
            if(arr[j]<pivot){
                i++ ;
                int temp =arr[i];
                arr[i] = arr[j];
                arr[j] = temp ;
            }
        }
        int temp =arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp ;
        return i+1  ;
    
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 3};
        quickSort(arr, 0, arr.length - 1);     // low=0,high = len-1
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}