class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        char[] chs = s.toCharArray();
        int lo = 0, hi = chs.length - 1;
        while (lo <= hi && chs[lo] == chs[hi]) {
            lo++;
            hi--;
        }
        if (lo > hi)
            return true;
        int lo2 = lo + 1, hi2 = hi - 1;
        while (lo2 <= hi && chs[lo2] == chs[hi]) {
            lo2++;
            hi--;
        }
        if (lo2 > hi)
            return true;
        while (lo <= hi2 && chs[lo] == chs[hi2]) {
            lo++;
            hi2--;
        }
        if (lo > hi2)
            return true;
        return false;
    }
}