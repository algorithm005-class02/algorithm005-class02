/**
 * 转换成小写字母
 * https://leetcode.com/problems/to-lower-case/
 */
public class Leetcode_709_toLowerCase {
    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char)(arr[i] - 'A' + 'a');
            }
        }
        return new String(arr);
    }
}
