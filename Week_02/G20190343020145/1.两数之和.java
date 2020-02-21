//一遍hash表 时间复杂度O(n),我们把包含有 nn 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1)O(1) ，所以时间复杂度为 O(n)O(n)。
//空间复杂度O(n) 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n个元素。
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         Map<Integer,Integer> hm = new HashMap<>(); 
//         for(int i = 0;i< nums.length;i ++){
//             hm.put(nums[i], i);
//         }  
//         for(int i = 0;i< nums.length;i ++) {
//             int findnum = target - nums[i];
//             if(hm.containsKey(findnum) && hm.get(findnum) != i)
//                 return new int[] { i, hm.get(findnum) };
//         }
//         throw new IllegalArgumentException("No two sum solution");
//     }

// }


//一遍哈希表
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>(); 
        for(int i = 0;i< nums.length;i ++) {
            int findnum = target - nums[i];
            if(hm.containsKey(findnum) && hm.get(findnum) != i)
                return new int[] { i, hm.get(findnum) };
            hm.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}