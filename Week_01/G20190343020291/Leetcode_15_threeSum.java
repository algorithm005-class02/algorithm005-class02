import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * https://leetcode.com/problems/3sum/
 */
public class Leetcode_15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            } else if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            } else {
                int i = k+1, j = nums.length-1;
                while (i < j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                        while (i < j && nums[i] == nums[++i]);
                        while (i < j && nums[j] == nums[--j]);
                    } else if (sum > 0) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
        }
        return res;
    }
}
