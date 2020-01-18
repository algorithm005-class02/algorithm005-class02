package week01.work;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *
 */
public class LeeCode26_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        if(nums!=null){
            for(int i=0;i<nums.length;i++){
                if(i==0){
                    nums[index] = nums[i];
                    continue;
                }

                if(nums[index]!=nums[i]){
                    nums[++index] = nums[i];
                }
            }
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        LeeCode26_RemoveDuplicates lc = new LeeCode26_RemoveDuplicates();
        int[] nums = {1,2,2};
        int lens = lc.removeDuplicates(nums);

        for(int i=0;i<lens;i++){
            System.out.print(nums[i]+",");
        }
    }
}
