import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // 1.字符排序，比较是否相等(总结类似的问题，最终都可以转化为排序后的操作)
    // 2.比较每个字符出现的次数是否相等

//    public boolean isAnagram(String s, String t) {
//        if (null == s && null == t) {
//            return true;
//        }
//        if (null != s && null == t) {
//            return false;
//        }
//        if (null == s) {
//            return false;
//        }
//        char[] a = s.toCharArray();
//        char[] b = t.toCharArray();
//        Arrays.sort(a);
//        Arrays.sort(b);
//        return Arrays.equals(a, b);
//    }

    public boolean isAnagram(String s, String t) {
        if (null == s && null == t) {
            return true;
        }
        if (null != s && null == t) {
            return false;
        }
        if (null == s) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        if (a.length != b.length) {
            return false;
        }
        for (int index = 0; index < a.length; index ++) {
            char c = a[index];
            char d = b[index];
            Integer num = map.get((int) c);
            if (num == null) {
                num = 0;
            }
            num += 1;
            map.put((int) c, num);

            num = map.get((int) d);
            if (num == null) {
                num = 0;
            }
            num -= 1;
            map.put((int) d, num);
        }
        for (int num : map.values()) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

}
