package rotate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author scott 2019/12/15
 */
class Solution1Test {


    @org.junit.jupiter.api.Test
    void rotate1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        print(nums);
        rotate.Solution1 solution = new rotate.Solution1();
        solution.rotate(nums, 2);
        print(nums);
        assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, nums);
    }

    @org.junit.jupiter.api.Test
    void rotate2() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        print(nums);
        rotate.Solution1 solution = new rotate.Solution1();
        solution.rotate(nums, 3);
        print(nums);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);

    }

    @org.junit.jupiter.api.Test
    void rotate3() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        print(nums);
        rotate.Solution1 solution = new rotate.Solution1();
        solution.rotate(nums, 3);
        print(nums);
        assertArrayEquals(new int[]{4, 5, 6, 1, 2, 3}, nums);
    }

    void print(int[] nums) {
        for (int item : nums) {
            System.out.print(item);
        }
        System.out.println("--");
    }
}