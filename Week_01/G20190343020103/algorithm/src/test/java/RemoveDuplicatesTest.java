import org.junit.Assert;
import org.junit.Test;

/**
 * @author scott 2019/12/15
 */
public class RemoveDuplicatesTest {
    @Test
    public void testRemoveDuplicates() {
        int[] nums = new int[]{1, 1, 2};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        Assert.assertEquals(2, removeDuplicates.removeDuplicates(nums));
        Assert.assertEquals(1, nums[0]);
        Assert.assertEquals(2, nums[1]);
    }
    @Test
    public void testRemoveDuplicates2() {
        int[] nums = new int[]{0, -3, -1,0,10};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        Assert.assertEquals(4, removeDuplicates.removeDuplicates(nums));
        Assert.assertEquals(0, nums[0]);
        Assert.assertEquals(-3, nums[1]);
        Assert.assertEquals(-1, nums[2]);
        Assert.assertEquals(10, nums[3]);
    }
}