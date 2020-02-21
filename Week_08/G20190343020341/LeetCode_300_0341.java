import java.util.Arrays;

public class LeetCode_300_0341 {
    public static void main(String[] args) {
        new Solution300().lengthOfLIS(new int[]{
                10,9,2,5,3,7,101,18});
    }
}

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int a[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = 1;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            int k = i;
            int temp = a[i - 1];
            boolean find = false;
            while (k < nums.length  ) {
                if(nums[i - 1] < nums[k]) {
                    temp = Math.max(a[k], temp);
                    find = true;
                }
                k++;
            }
            if (find) {
                a[i - 1] = temp + 1;
            }

        }
        Arrays.sort(a);
        return a[a.length - 1];
    }
}
