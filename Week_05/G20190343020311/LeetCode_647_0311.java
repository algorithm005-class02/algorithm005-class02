class Solution {
    public int countSubstrings(String s) {
        int N = s.length(), ans = 0;

        // center: position of the center of palindromic string
        // 2*N-1: all possible positions of center
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}