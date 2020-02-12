import java.util.Arrays;

public class isAnagram {
    public boolean isAnagram(String s, String t) {

//        if (s.length() != t.length()) {
//            return false;
//        }
//        char[] array_s = s.toCharArray();
//        char[] array_t = t.toCharArray();
//
//        Arrays.sort(array_s);
//        Arrays.sort(array_t);
//        return Arrays.equals(array_s, array_t);

        if (s.length() != t.length()) {
            return false;
        }

        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }
        for (int item : a) {
            if (item != 0) {
                return false;
            }
        }
        return true;
    }
}
