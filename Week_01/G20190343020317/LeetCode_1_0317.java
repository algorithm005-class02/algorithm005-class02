class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        int len = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i<len; i++){
            int temp = nums[i];
            if(indexMap.containsKey(target-temp)){
                indexes[0] = indexMap.get(target-temp);
                indexes[1] = i;
                break;
            }else {
                indexMap.put(temp, i);
            }
        }
        return indexes;
    }
}