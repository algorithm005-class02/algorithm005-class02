class Solution {
    public int[] twoSum(int[] nums, int target) {
        //使用hashmap，降低时间复杂度 ,执行用时3ms，内存消耗 36.7MB
        int[] resultArray = new int[2];
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            hashmap.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++){
            int result = target - nums[i];
            Integer index = hashmap.get(result);
            if(index != null && index != i){
                resultArray[0] = i;
                resultArray[1] = index;
                break;
            }
        }
        return resultArray;
    }
}