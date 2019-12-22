
class remove_duplicated_from_sorted_array {
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
        remove_duplicated_from_sorted_array deleteDuplicate = new remove_duplicated_from_sorted_array();
        int[] nums=new int[]{1,1,1,1,1,2};
        int length = deleteDuplicate.removeDuplicates(nums);
        System.out.println(length);


    }
}