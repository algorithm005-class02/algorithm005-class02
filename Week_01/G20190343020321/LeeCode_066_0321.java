class LeeCode_066_0321 {
    /**
     * plusOne
     * 加1
     */
    public static void main(String[] args) {
        int[] twoSum = new LeeCode_066_0321.Solution().plusOne(new int[]{3, 8, 7, 9, 4});
        for (int i = 0; i < twoSum.length; i++) {
            System.out.println(twoSum[i]);
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
    }
}


