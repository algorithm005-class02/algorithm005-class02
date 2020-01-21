class Solution {
    public boolean isAnagram(String s, String t) {
         if (s.length() != t.length()) {
            return   false;
        }
        char[] s_ary = s.toCharArray();
        char[] t_ary = t.toCharArray();
        Arrays.sort(s_ary);
        Arrays.sort(t_ary);
        return Arrays.equals(s_ary,t_ary);
    }
}