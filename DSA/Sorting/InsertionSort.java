public class InsertionSort{
    public static void main(String[] args){
      int arr[] =  {5,6,3,4,7}  ;
      for(int i=1;i<arr.length;i++){
        int key = arr[i];
        int j = i-1;
        while(j>=0 && arr[j]>key){
            arr[j+1] = arr[j];
            j-- ;
        }
        arr[j+1] = key ;        // when j becomes -1  or  // kyuki j+1 hi sabse chhota hai .
      }
      for(int num : arr){
        System.out.print(num +" ");
      }
    }
}