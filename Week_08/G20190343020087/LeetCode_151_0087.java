public class Solution {
    public String reverseWords(String s) {
        if (s.isEmpty())
            return s;
        StringBuilder sb = new StringBuilder();
        int endIndex = s.length();
        int beginIndex;
        while ((beginIndex = s.lastIndexOf(' ', endIndex - 1)) != -1) {
            String value = s.substring(beginIndex + 1, endIndex);
            if (!value.isEmpty()) {
                sb.append(value).append(" ");
            }
            endIndex = beginIndex;
        }
        if (endIndex == 0 && sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(s.substring(0, endIndex));
        }
        return sb.toString();
    }
}