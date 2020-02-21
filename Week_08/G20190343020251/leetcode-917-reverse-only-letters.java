class Solution {
    public String reverseOnlyLetters(String S) {
        int left = 0, right = S.length()-1;
        char[] chars = S.toCharArray();
        while (left < right) {
            while ( left<S.length() && !isAbc(chars[left]) ) left++;
            while ( right>=0 && !isAbc(chars[right]) ) right--;
            if (left >= right) break;
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
        return String.valueOf(chars);
    }

    public boolean isAbc(char ch) {
        if ( (ch >='A' && ch <='Z') || ( ch >='a' && ch<='z') ) return true;
        return false;
    }
}
