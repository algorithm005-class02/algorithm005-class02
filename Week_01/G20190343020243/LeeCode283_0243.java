package week01.work;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class LeeCode283_MoveZeroes {
    /**
     * 1.将所有非零元素依次移动到数组的开头
     * 2.将剩下的元素全部设置为0
     *
     * @param nums
     */
    public void moveZeroes(int[] nums){
        int index = 0;
        for(int num:nums){
            if(num!=0){
                nums[index++] = num;//将非零元素移动到数组的前端（按顺序）
            }
        }

        while(index<nums.length){//将最后一个非零元素之后的元素全部设置为0
            nums[index++] = 0;
        }
    }

}
