import java.util.Arrays;
import java.util.stream.Collectors;

// 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
class LeetCode_26_0299 {
    public static int removeDuplicates(int[] nums) {

        // 双指针法
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 2, 2, 3, 4, 5, 6, 6, 7 };
        int res = removeDuplicates(nums);
        String numsStr = Arrays.stream(nums).boxed().map(x -> x.toString()).collect(Collectors.joining(","));

        System.out.println(res);
        System.out.println(numsStr);
    }
}