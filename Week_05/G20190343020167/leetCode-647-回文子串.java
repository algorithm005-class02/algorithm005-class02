class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][i] = true;
        }
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = L + i - 1;
                if (L == 2) {
                    if (s.charAt(i) == s.charAt(j)) {
                        arr[i][j] = true;
                    }
                }
                if (s.charAt(i) == s.charAt(j) && arr[i + 1][j - 1]) {
                    arr[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}