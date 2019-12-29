class LeeCode_066_0321 {
    /**
     * plusOne
     * 加1
     */
    public static void main(String[] args) {
        int[] plusOne = new LeeCode_066_0321.Solution().plusOne_1(new int[]{3, 8, 7, 9, 4});
        for (int i = 0; i < plusOne.length; i++) {
            System.out.println(plusOne[i]);
        }
        }



    static class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            for(int i = len - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] %= 10;
                if(digits[i]!=0)
                    return digits;
            }
            digits = new int[len + 1];
            digits[0] = 1;
            return digits;
        }

        public int[] plusOne_1(int[] digits) {
            for(int i=digits.length-1;i>=0;i--){
                digits[i] =1+ digits[i];
                if (digits[i]==10){
                    digits[i]=0;
                }else{
                    return digits;
                }

            }
            int[] other = new int[digits.length+1];
            other[0]=1;
            for (int i=1;i<other.length;i++) {
                other[i]=digits[i-1];
            }
            return other;
        }
    }
}


