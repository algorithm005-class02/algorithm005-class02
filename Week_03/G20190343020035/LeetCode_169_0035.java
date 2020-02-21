import org.junit.Test;

public class LeetCode_169_0035{

      @Test
    public  void test1(){
         int[] nums = new int[]{11,11,10,12,13};
         int result =  majorityElement(nums);
         System.out.println(result);
    }

    public int majorityElement(int[] nums) {
        return majorityElementec(nums, 0, nums.length - 1);
    }

        private int majorityElementec(int[] nums, int lo, int hi) {
            if (lo == hi) {
                return nums[lo];
            }


            int mid = (hi - lo) / 2 + lo;
            int left  = majorityElementec(nums, lo, mid);
            int right = majorityElementec(nums, mid + 1, hi);

            if (left == right) {
                return left;
            }
            int leftCount = countInRange(nums, left, lo, hi);
            int rightCount = countInRange(nums, right, lo, hi);
            return leftCount > rightCount ? left : right;
        }

        private int countInRange(int[] nums, int num, int lo, int hi) {
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }
    }


