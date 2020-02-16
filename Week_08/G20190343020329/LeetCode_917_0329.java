
//917. 仅仅反转字母
class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder ans = new StringBuilder();
        char[] chs = S.toCharArray();
        int length = chs.length;
        int temp = length - 1;
        for (int i = 0; i < length; i ++) {
            if (('a' <= chs[i] && chs[i] <= 'z') || ('A' <= chs[i] && chs[i] <= 'Z')) {
                while (!(('a' <= chs[temp] && chs[temp] <= 'z')|| ('A' <= chs[temp] && chs[temp] <= 'Z'))) {
                    temp --;
                }
                ans.append(chs[temp]);
                temp --;
            } else {
                ans.append(chs[i]);
            }
        }
        return ans.toString();
    }
}