package G20190343020095;

/**
 *  * @author jiangli
 *  * @date 2020/2/29 21:49
 *  * @description
 *  
 */
public class LeetCode_8_0097 {

    public int myAtoi(String str) {
        if (str.length() == 0) return 0;
        int index = 0, sign = 1, total = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            System.out.println(total + ":" + digit);
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            System.out.println(total + ":" + digit);
            total = total * 10 + digit;
            index++;
        }
        return total * sign;
    }
}
