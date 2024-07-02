public class SelectionSort{
    public static void main(String[] args) {
        int nums[] = {6,5,2,8,9,4};
        int size =  nums.length ;
        int temp = 0 ;
        int minIndex ;

        System.out.println("before sortting:");
        for(int num : nums){
            System.out.print(num + " ");
        }

        for(int i =0; i<size-1; i++){
            minIndex = i ;
            for(int j=i; j<size;j++){
                if(nums[minIndex] > nums[j]){
                    minIndex = j ;
                }
                // temp  = nums[minIndex];
                // nums[minIndex] = nums[i];
                // nums[i] = temp ;               // analyse this part and tell output. --> done i, will be global variable
            }
            temp  = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp ;
        }

        System.out.println("after sortting:");
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}