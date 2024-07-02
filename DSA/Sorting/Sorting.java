public class Sorting{
    public void bubbleSort(){
        int[] arr = {1,3,2,3,3,5,4,9};
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp ;
                }
            }
        }
        for(int num:arr){
            System.out.print(num+" ");
        }
    }

    public void insertionSort(){
        int key;
        int [] arr = {2,34,2,14,5,7,9,5,3};
        for(int i=1;i<arr.length;i++){
            key = arr[i] ;
            int j = i-1 ;
            while(j>=0 && arr[j]>key){
                if(arr[j]>arr[j+1]){
                    arr[j] = arr[j+1];
                    j-- ;
                }
            }
            arr[j+1] = key ;
        }
        for(int num:arr){
            System.out.print(num +" ");
        }
    }
    public static void main(String[] args) {
        Sorting obj = new Sorting();
        obj.bubbleSort();
        obj.insertionSort() ;

    }
}