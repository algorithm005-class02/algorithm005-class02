class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;  //补充条件，用于推导dp[2]
        dp[1] = s.charAt(0)=='0' ? 0 : 1;
        for(int i=2; i<=s.length(); i++){
            int lastOne = Integer.valueOf(s.substring(i-1,i));  //倒数1位
            int lastTwo = Integer.valueOf(s.substring(i-2,i));  //倒数2位
            if(lastOne>=1 && lastOne <=9){
                dp[i] += dp[i-1];  
            }
            if(lastTwo>=10 && lastTwo <=26){ //是一个小于等于26的两位数，可以合并来表示一个字母
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}

