public class rotate_array {
    public void rotate(int[] nums, int k) {

        int len_nums = nums.length;
        if (len_nums==0 || len_nums==1) {
            return;
        }
        int real_k = k % len_nums;
        if(real_k==0)
            return;
        int prev,temp;
        for (int i=1;i<=k;i++){
            prev=nums[len_nums-1];
            for (int j=0;j<len_nums;j++) {
                temp = nums[j];
                nums[j]=prev;
                prev=temp;
            }
        }
    }
}