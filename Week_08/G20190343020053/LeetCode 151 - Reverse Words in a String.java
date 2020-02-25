class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        int size = s.length();
        reverse(0, size - 1, ca);
        reverseWords(ca, size);
        
        return cleanSpace(ca, size);
    }
    
    private String cleanSpace(char[] ca, int size) {
        int i = 0;
        int j = 0;
        while (j < size) {
            while (j < size && ca[j] == ' ') {
                j++;
            }
            while (j < size && ca[j] != ' ') {
                ca[i++] = ca[j++];
            }
            while (j < size && ca[j] == ' ') {
                j++;
            }
            if (j < size) {
                ca[i++] = ' ';
            }
        }
        return new String(ca).substring(0,i);
    }
    
    private void reverseWords(char[] ca, int size) {
        int i = 0;
        int j = 0;
        while (i < size) {
            while (i < j || (i < size && ca[i] == ' ')) {
                i++;
            }
            while (j < i || (j < size && ca[j] != ' ')) {
                j++;
            }
            reverse(i, j - 1, ca);
        }
    }
    
    private void reverse(int st, int en, char[] ca) {
        while (st < en) {
            char tmp = ca[st];
            ca[st++] = ca[en];
            ca[en--] = tmp;
        }
    }
}