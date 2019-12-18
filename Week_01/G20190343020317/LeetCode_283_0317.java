class Solution {
    
    /**
     * 双指针
     */
    public void moveZeroes(int[] nums) {
        int move = 0;
        int nonZero = 0;
        while (move<nums.length){
            if(nums[move]!=0){
                nums[nonZero] = nums[move];
                nonZero++;
            }
            move++;
        }
        while (nonZero<nums.length){
            nums[nonZero] = 0;
            nonZero++;
        }
    }
    
    /**
     * 非双指针，用 for each节约一个内存
     */
    public void moveZeroes(int[] nums) {
        int move = 0;
        for(int num: nums){
            if (num!=0){
                nums[move] = num;
                move++;
            }
        }
        while (move<nums.length){
            nums[move] = 0;
            move++;
        }
    }
    
    /**
     * 66 加一
     */
    public int[] plusOne(int[] digits) {
        int result = new int[digits.length+1];
        for(int i = digits.length-1;i>-0;i--){
            if (i==digits.length-1){
                result[i] = (digits[i]+1)%10;
                result[i-1] += (digits[i]+1)/10;
            }else {
                result[i] = (digits[i]+result[i])%10;
                result[i-1] += (digits[i]+result[i])/10;
            }
        }
        if (result[0] == 0){
            return
        }
    }
}

