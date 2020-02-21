
/**
 * 思路：sum-target 放到一个hashmap中
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length= nums.length;
        Map <Integer,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            if(map.containsKey(target-nums[i])){
                return new int []{i,map.get(target-nums[i])}; 
            }
            map.put(nums[i],i);
        }
        return new int[]{};
        /*
        int [] rtVal ={0,0};  
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if((nums[i]+nums[j])==target){
                    rtVal[0]=i;
                    rtVal[1]=j;
                    return rtVal;
                }
            }
        }
        return rtVal;
        */
        
    }
}