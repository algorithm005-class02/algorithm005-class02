class Solution {
    public String reverseStr(String s, int k) {
        char[] ca = s.toCharArray();
        int size = s.length();
        for (int i = 0;i < size;i+=2*k) {
            int len = (size - i) > k ? k : (size - i);
            int st = i;
            int en = i + len - 1;
            while (st < en) {
                char c = ca[st];
                ca[st] = ca[en];
                ca[en] = c;
                st++;
                en--;
            }
        }
        return new String(ca);
    }
}