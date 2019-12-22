class Solution {
    public int removeDuplicates(int[] nums) {
        //此题和删除零元素原理相同，采用滚雪球的方式。
        //区别在于（1）初始位置必须是1（2）不能再使用交换，而是使用赋值。比如1,1,2,2。。。如果是交换，一开始会成为1,2,1,2。那么后续的2将不会重复，所以应该是赋值。成为1,2,2,2,
        if(nums.length <=1)return nums.length;
        int j = 1; //初始位置
        int snowBallSize = 0;
        for (int i = 1;i < nums.length ;i++){
            if(nums[i] != nums[i-1]){
                for(int m = j;m < i;m ++){
                    nums[m] = nums[i];
                }
                j++;
            }else{
                snowBallSize++;
            }
        }
        return nums.length - snowBallSize;
    }
}