package Array;
/**
 * author: Ziv
 * description:
 * Date:Created in
 */

import java.util.Arrays;

/**
 *
 *
 * @author piper
 * @date 2019/12/3 12:41 
 * @decrisption
 */
public class LeetCode_108__0249 {

    public static void main(String[] args) {
        LeetCode_108__0249 leetCode_108__0249 = new LeetCode_108__0249();
        int[] i=new int[]{0,1,0,3,12};
        leetCode_108__0249.moveZeroes(i);
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }

        }
        while(nums.length>j) {
            nums[j++] =0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
