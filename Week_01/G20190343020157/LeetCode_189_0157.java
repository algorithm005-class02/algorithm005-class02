class Solution {
    public void rotate(int[] nums, int k) {
        //  暴力解法 执行用时：82ms，内存消耗：36.6MB
        // for(int j =0;j < k; j++){
        //     int last = nums[0];
        // for(int i = 1; i < nums.length;i++){
        //     int temp = nums[i];
        //     nums[i] = last;
        //     last = temp;           
        // }
        // nums[0] = last;
        // }



        //第一次优化 执行用时：1ms，内存消耗：36.6MB，击败大多数用户
        if(nums.length <= k) k= k%nums.length;
        if(k ==0)return;
        int[] tempNum = new int[k];
        for(int i = 0; i < k;i++){
            tempNum[i] = nums[nums.length - k + i ];
        }
        //
        for(int j = nums.length -k - 1 ; j >= 0 ;j--){
            nums[j+k] = nums[j];
        }
        for(int i = 0; i < k; i++){
            nums[i] = tempNum[i];
        }


        //第二次优化？
    }
}