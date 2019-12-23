public class move_zero {

    public void moveZeroes(int[] nums) {
        for (int i=nums.length-1;i>=0;i--) {
            if (nums[i]==0){
                for(int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
                nums[nums.length-1]=0;
            }
        }
    }
}