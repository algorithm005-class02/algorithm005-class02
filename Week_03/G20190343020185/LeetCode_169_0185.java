class Solution {
    public int majorityElement(int[] nums) {
        int s=nums[0],t=1;
        for(int i = 1;i < nums.length; i++){
            if(s == nums[i]){
                t++;
            }
            else{
                t--;
            }
            if(t==0) {
                s = nums[i];
                t = 1;
            }
        }
        return s;
    }
}
