public class BubbleSort{
    public static void main(String[] args) {
        int nums[] = {6,5,4,8,9,2};
        int size = nums.length ;
        System.out.print("before sorting:");
        for(int num : nums){
            System.out.print(num + " ");
        }

        for(int i=0;i<size;i++){
            for(int j=0;j<size-i-1;j++){  //size-1 bcz j should end before last value
                if(nums[j]<nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp ;
                }
            }
            for(int num:nums){
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.println("after sorting:");
        for(int num:nums){
            System.out.print(num + " ");
        }
    }
}