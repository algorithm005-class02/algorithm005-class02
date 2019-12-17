package Array;/**
 * author: Ziv
 * description:
 * Date:Created in
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author piper
 * @date 2019/12/10 21:40 
 * @decrisption
 * //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * //
 * // 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * //
 * // 示例:
 * //
 * // 给定 nums = [2, 7, 11, 15], target = 9
 * //
 * //因为 nums[0] + nums[1] = 2 + 7 = 9
 * //所以返回 [0, 1]
 * //
 * // Related Topics 数组 哈希表
 */
public class LeetCode_1_0249 {
    public static void main(String[] args) {
        LeetCode_1_0249 test = new LeetCode_1_0249();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        //时间复杂度为O(n)
        int[] twoSum = test.twoSum(nums, target);
        //暴力解决 时间复杂度为O(n^2)
        int[] twoSum_ = test.twoSum_(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }

    public int[] twoSum(int[] nums, int target) {
//        //1.两个for循环，所有数字加起来等于target
//        for(int i = 0; i < nums.length; i++) {
//            for(int j = i+1; j < nums.length; j++) {
//                if(nums[i] + nums[j] == target) return new int[]{i,j};
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
        //2.用hashMap
        int[] array = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey((target - nums[i]))) { //第二次遍历时候，就会得到 9 - 7 =2
                array[1] = i;
                array[0] = map.get(target - nums[i]);
                return array;
            }
            map.put(nums[i], i); //第一个遍历保留了（2,0）
        }
        return array;
    }

    //暴力解决法
    public int[] twoSum_(int[] nums, int target) {
        //1.两个for循环，所有数字加起来等于target
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) return new int[]{i,j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
