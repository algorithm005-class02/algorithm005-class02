class Solution {
    
    /**
     * 66 先处理高位数字的结果
     */
    public int[] plusOne(int[] digits) {
        int [] result = new int[digits.length+1];
        for(int i = digits.length-1; i>=0; i--){
            if (i==digits.length-1){
                result[i] += (digits[i]+1)/10;
                result[i+1] = (digits[i]+1)%10;
            }else {
                result[i] += (digits[i]+result[i+1])/10;
                result[i+1] = (digits[i]+result[i+1])%10;
            }
        }
        if (result[0] == 0){
            return Arrays.copyOfRange(result, 1, result.length);
        }else {
            return result;
        }
    }
}