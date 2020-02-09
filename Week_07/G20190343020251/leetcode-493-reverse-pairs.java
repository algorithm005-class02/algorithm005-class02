class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null && nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length-1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int cnt = mergeSort(nums, left, mid) + mergeSort(nums, mid+1, right);
        int i=left, t=left, j=mid+1, k=0;
        int[] temp = new int[right - left + 1];
        for (; j<=right; j++) {
            while (t<=mid && nums[t]<=(long)2*nums[j]) t++;
            while (i<=mid && nums[i]<=nums[j]) temp[k++] = nums[i++];
            temp[k++] = nums[j];
            cnt += mid - t + 1;
        }
        while (i<=mid) temp[k++] = nums[i++];
        System.arraycopy(temp, 0, nums, left, temp.length);
        return cnt;
    }
}
