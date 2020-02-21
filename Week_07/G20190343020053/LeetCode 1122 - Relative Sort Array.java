class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1005];
        for (int num : arr1) {
            cnt[num]++;
        }
        int[] res = new int[arr1.length];
        int p = 0;
        for (int num : arr2) {
            while (cnt[num] != 0) {
                res[p++] = num;
                cnt[num]--;
            }
        }
        for (int i = 0;i <= 1000;i++) {
            while (cnt[i] != 0) {
                res[p++] = i;
                cnt[i]--;
            }
        }
        return res;
    }
}