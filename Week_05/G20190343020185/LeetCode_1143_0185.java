class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] arr=new int[len1+1][len2+1];
        for(int i = len1 - 1;i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                int tmp = arr[i+1][j] > arr[i][j+1] ? arr[i+1][j] : arr[i][j+1];
                arr[i][j] = (text1.charAt(i) == text2.charAt(j)) ? arr[i+1][j+1] + 1 : tmp;
            }
        }
        return arr[0][0];
    }
}
