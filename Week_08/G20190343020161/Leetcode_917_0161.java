public class reverseOnlyStr {
    public static String reverseOnlyLetters(String S) {
        if(S.length()<=0) return S;
        char[] res = S.toCharArray();
        int i = 0, j = S.length() - 1;
        while (i < j) {
            while (!Character.isLetter(res[i]) && i < j) i++;
            while (!Character.isLetter(res[j]) && i < j) j--;
            char temp = res[i];
            res[i++] = res[j];
            res[j--] = temp;
        }
        return new String(res);
    }
}
