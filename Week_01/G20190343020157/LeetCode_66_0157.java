class Solution {
    public int[] plusOne(int[] digits) {
        //暴力解法 ,执行用时 0ms，内存消耗 35.2MB
        int temp = 1;
        for (int i = digits.length -1;i >= 0; i--){
            digits[i] += temp;
            if(digits[i] == 10){
                digits[i] = 0;
                temp = 1;
            }else{
                temp = 0;
                break;
            }
        }
        if (temp == 1){
            int [] a = new int[digits.length+1];
            a[0] =1;
            digits = a;
        }
        return digits;
    }

    //第一次优化？
}