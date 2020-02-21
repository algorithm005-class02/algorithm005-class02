class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        byte[] s_byteArray = s.getBytes();
        byte[] t_byteArray = t.getBytes();
        Arrays.sort(s_byteArray);
        Arrays.sort(t_byteArray);
        return Arrays.equals(s_byteArray,t_byteArray);
    }
}