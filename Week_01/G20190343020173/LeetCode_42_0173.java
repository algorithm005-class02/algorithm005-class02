public class LeetCode_42_0173 {
    class Solution {
        public int trap(int[] A) {
            if (A.length < 3) return 0;

            int ans = 0;
            int l = 0, r = A.length - 1;

            // find the left and right edge which can hold water
            while (l < r && A[l] <= A[l + 1]) l++;
            while (l < r && A[r] <= A[r - 1]) r--;

            while (l < r) {
                int left = A[l];
                int right = A[r];
                if (left <= right) {
                    // add volum until an edge larger than the left edge
                    while (l < r && left >= A[++l]) {
                        ans += left - A[l];
                    }
                } else {
                    // add volum until an edge larger than the right volum
                    while (l < r && A[--r] <= right) {
                        ans += right - A[r];
                    }
                }
            }
            return ans;
        }
    }
}