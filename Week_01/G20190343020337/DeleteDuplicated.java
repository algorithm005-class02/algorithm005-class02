package algorithm.leetcode;

class DeleteDuplicate {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length ==1 )
            return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i=i+1;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String args[]){
        DeleteDuplicate deleteDuplicate = new DeleteDuplicate();
        int[] nums=new int[]{1,1,1,1,1,2};
        int length = deleteDuplicate.removeDuplicates(nums);

        for(int z:nums){
            System.out.println(z);
        }
        System.out.println(length);
    }
}