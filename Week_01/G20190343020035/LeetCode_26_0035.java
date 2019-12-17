//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次
// 返回移除后数组的新长度。


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class LeetCode_26_0035 {
    public int removeDuplicates(int[] nums) {
        /**
         *   定义一个快指针i ,慢指针 j
         *   从数组头部开始遍历，如果2个元素相等，j++,否则 nums[i+1] = nums[j],i++,j++
         */
        int i = 0, j = 1;
        for ( ; j < nums.length; ){
            if(nums[i] == nums[j]){
                j++;
            }else{
                nums[++i] = nums[j++];
            }
        }
        return  i+1;
    }

    @Test
    public void t1(){
        System.out.println(removeDuplicates(new int[]{1,2,3}));
    }
}
