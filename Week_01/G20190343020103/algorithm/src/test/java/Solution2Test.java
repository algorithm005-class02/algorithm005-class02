import org.junit.Assert;
import org.junit.Test;
import removeDuplicates.Solution2;

/**
 * @author scott 2019/12/15
 */
public class Solution2Test {
    @Test
    public void testRemoveDuplicates0() {
        int[] nums = new int[]{};
        Solution2 solution1 = new Solution2();
        Assert.assertEquals(0, solution1.removeDuplicates(nums));
        Assert.assertEquals(0, nums.length);
    }

    @Test
    public void testRemoveDuplicates1() {
        int[] nums = new int[]{1, 1, 2};
        Solution2 solution1 = new Solution2();
        Assert.assertEquals(2, solution1.removeDuplicates(nums));
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }

    @Test
    public void testRemoveDuplicates2() {
        int[] nums = new int[]{-4, -3, -1, -1, 10};
        Solution2 solution1 = new Solution2();
        Assert.assertEquals(4, solution1.removeDuplicates(nums));
        Assert.assertEquals(-4, nums[0]);
        Assert.assertEquals(-3, nums[1]);
        Assert.assertEquals(-1, nums[2]);
        Assert.assertEquals(10, nums[3]);
    }

    @Test
    public void testRemoveDuplicates4() {
        int[] nums = new int[]{1, 2, 3, 3};
        Solution2 solution1 = new Solution2();
        Assert.assertEquals(3, solution1.removeDuplicates(nums));
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
        Assert.assertEquals(3, nums[2]);
    }
}