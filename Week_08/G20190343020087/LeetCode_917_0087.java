class Solution {
    public String reverseOnlyLetters(String S) {
        int i = 0, j = S.length() - 1;
        char[] chars = S.toCharArray();
        while (i < j) {
            while (!Character.isAlphabetic(chars[i]) && i < j)
                i++;
            while (!Character.isAlphabetic(chars[j]) && i < j)
                j--;
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
    }
}