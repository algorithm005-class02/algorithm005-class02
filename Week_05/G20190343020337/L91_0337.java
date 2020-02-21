package algorithm.leetcode.动态规划;

import java.util.HashMap;
import java.util.Map;

public class L91_decode {


    public int numDecodings(String s) {


        if(s.startsWith("0"))
            return 0;
        return _dp(s);
        //return _brutalDecoding(0,s.length(),s);
    }

    /**
     * 方法1：类似爬楼的递归方式，暴力实现
     */

    public int _brutalDecoding(int level,int n,String s){


        if(level==n-1){
            if(s.charAt(level)=='0'){
                return 0;
            }else{
                return 1;
            }
        }
        if( level >n-1)
        {
            return 1;
        }
        if( level ==n-2){
            String end = s.substring(n-2);
            int parsedInt = Integer.parseInt(end);
            if(end.startsWith("0")){
                return 0;
            }
            if(end.endsWith("0")){
                if(parsedInt==10||parsedInt==20){
                    return 1;
                }else{
                    return 0;
                }
            }
            if(parsedInt>26){
                return 1;
            }else{
                return 2;
            }


        }
        int next1=0;
        int next2=0;
        char next_1 = s.charAt(level);
        if(next_1=='0'){
            next1=0;
            next2=0;

        }
        else {
            next1 = _brutalDecoding(level + 1, n, s);

            String next_2 = s.substring(level,level+2);
            if(Integer.parseInt(next_2)<=26)
                next2 = _brutalDecoding(level + 2, n, s);
            else{
                next2=0;
            }



        }

        return next1+next2;
    }

    public int _dp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }





    public static void main(String args[]){
        L91_decode decode = new L91_decode();
        decode.numDecodings("230");
    }
}
