class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] !=0){
                swap(nums,i,j);
                j++;
            }
            
        }
    }

    static void swap(int[] array,int a,int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }   


}


