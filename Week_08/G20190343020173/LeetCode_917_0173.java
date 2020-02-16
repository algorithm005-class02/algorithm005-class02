package org.crayzer.leetcode.editor.en.string;

public class LeetCode_917_ReverseOnlyLetters {
    class Solution {
        public String reverseOnlyLetters(String S) {
            if (S == null) return S;
            char[] arr = S.toCharArray();

            int s = 0;
            int e = S.length() - 1;
            while (s < e) {
                while (arr[s] < 'A' || (arr[s] > 'Z' && arr[s] < 'a') || arr[s] > 'z') {
                    if (s < e) {
                        s++;
                    } else {
                        return new String(arr);
                    }
                };
                while (arr[e] < 'A' || (arr[e] > 'Z' && arr[e] < 'a') || arr[e] > 'z') {
                    if (s < e) {
                        e--;
                    } else {
                        return new String(arr);
                    }
                }
                if (s < e) {
                    char tmp = arr[s];
                    arr[s++] = arr[e];
                    arr[e--] = tmp;
                }
            }
            return new String(arr);
        }
    }
}
