package GeekHomework;

public class removeDuplicates {
    public static void main(String[] args) {
        int [] test={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(test));
    }
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
//        for (int k = 0; k < nums.length; k++) {
//            System.out.print(nums[k] + " ");
//        }
        return i + 1;
    }
}
