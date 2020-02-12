public class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int start, int end){
        if(start>=end) return 0; 
        int mid = start + (end-start)/2; 
        int merge = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end); 
        for(int i = start, j = mid+1; i<=mid; i++){
            while(j<= end && nums[i]/2.0 > nums[j]) j++; 
            merge += j-(mid+1); 
        }
        Arrays.sort(nums, start, end+1); 
        return merge; 
    }
}
