package G20190343020095;

/**
 *  * @author jiangli
 *  * @date 2020/2/29 22:39
 *  * @description
 *  
 */
public class LeetCode_151_0097 {

    public String reverseWords(String s) {
        s = s.trim();
        if(s.equals("")) {
            return "";
        }
        String[] sp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = sp.length - 1; i >= 0; i--) {
            sp[i].trim();
            if(sp[i].equals("")) {
                continue;
            }
            sb.append(sp[i]);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    /**
     * 无法处理中间有连续空格的情况 待修改
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        //reverse整个string,再反转每个单词
        if (s.length() == 0) return s;
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }

        int begin = 0, end = 0;
        while (end < s.length()) {
            if (chars[end] == ' ') {
                for (int i = begin, j = end - 1; i < j; i++, j--) {
                    char c = chars[i];
                    chars[i] = chars[j];
                    chars[j] = c;
                }
                end++;
                begin = end;
            } else {
                end++;
            }
        }
        for (int i = begin, j = end - 1; i < j; i++, j--) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }
        return String.valueOf(chars);

    }

}
