package removeDuplicates;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author scott 2019/12/15
 */
class Solution1Test {
    @Test
    void testRemoveDuplicates0() {
        int[] nums = new int[]{};
        Solution1 solution1 = new Solution1();
        assertEquals(0, solution1.removeDuplicates(nums));
        assertEquals(0, nums.length);
    }

    @Test
    void testRemoveDuplicates1() {
        int[] nums = new int[]{1, 1, 2};
        Solution1 solution1 = new Solution1();
        assertEquals(2, solution1.removeDuplicates(nums));
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    void testRemoveDuplicates2() {
        int[] nums = new int[]{-4, -3, -1, -1, 10};
        Solution1 solution1 = new Solution1();
        assertEquals(4, solution1.removeDuplicates(nums));
        assertEquals(-4, nums[0]);
        assertEquals(-3, nums[1]);
        assertEquals(-1, nums[2]);
        assertEquals(10, nums[3]);
    }

    @Test
    void testRemoveDuplicates4() {
        int[] nums = new int[]{1, 2, 3, 3};
        Solution1 solution1 = new Solution1();
        assertEquals(3, solution1.removeDuplicates(nums));
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
    }
}