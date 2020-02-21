package org.crayzer.leetcode.editor.en.string;

public class LeetCode_125_ValidPalindrome {

    public static void main(String[] args) {

        Solution solution = new LeetCode_125_ValidPalindrome().new Solution();

        String testCase1 = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(testCase1));

        String testCase2 = "race a car";
        System.out.println(solution.isPalindrome(testCase2));
    }

    class Solution1 {
        public boolean isPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
                while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
                i++;j--;
            }
            return true;
        }
    }

    class Solution {
        public boolean isPalindrome(String s) {
            String filteredStr = filterNonNumberAndChar(s);
            String reverseStr = reverseString(filteredStr);
            return filteredStr.equalsIgnoreCase(reverseStr);
        }

        private String filterNonNumberAndChar(String s) {
            return s.replaceAll("[^a-zA-Z0-9]", "");
        }

        private String reverseString(String s) {
            return new StringBuilder(s).reverse().toString();
        }
    }
}
