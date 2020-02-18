class Solution {
    public int myAtoi(String str) { 
        int sign = 1;
        int total = 0;
        int index = 0;
        //空判断
        if(str.length() == 0 || str.trim().length() == 0) return 0;
        //去除空格
        while(str.charAt(index) == ' ' && index < str.length()){
            index ++;
        }
        //正负值判断
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+'? 1:-1;
            index ++;
        }
        //转换成数字
        while(index < str.length()){
            int digit = str.charAt(index) -'0';
            //判断是否是0-9的值
            if(digit > 9 || digit < 0){
                break;
            }
            //INT溢出判断
            if(total > Integer.MAX_VALUE / 10 ||
            total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10){
                return total = sign == -1 ?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            total = total * 10 + digit;
            index ++;
        }

        return total * sign;
        
        
    }
}