/**
 * @method "一遍哈希表"
 * @explain 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回。
 * @complexity 时间复杂度：O(n),空间复杂度：O(n)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 1.计算差值
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                // 2.如果哈希表里包含与差值相等的元素，则立即返回下标
                return new int[]{map.get(diff),i};
            }
            // 3.把数组中的值和下标放到哈希表里
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("Not Found");
    }
}
