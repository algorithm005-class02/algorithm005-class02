class Solution {
    public int myAtoi(String str) {
        boolean isPlus = true;
        if (str == null || str.length() == 0) {
            return 0;
        }

        int index = 0;
        while (index<str.length() && str.charAt(index)==' ') {
            index++;
        }

        if ( index<str.length() && (str.charAt(index)=='+' || str.charAt(index)=='-') ) {
            isPlus = str.charAt(index) == '+' ? true : false;
            index++;
        }

        int num = 0;
        while ( index<str.length()) {
            if (str.charAt(index)<'0' || str.charAt(index)>'9') break;

            if (Integer.MAX_VALUE/10 > num ||
                    (Integer.MAX_VALUE/10==num && Integer.MAX_VALUE%10 >= (str.charAt(index)-'0')) ) {

                num = num*10 + (str.charAt(index)-'0');
            } else {
                return isPlus ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }
        return isPlus ? num : -num;
    }
}
