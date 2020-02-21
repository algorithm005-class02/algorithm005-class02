package leetcode.week07;

public class LeetCode_231_0069 {

    public static void main (String args[]) {
        System.out.println(isPowerOfTwo(4));
    }

    public static boolean isPowerOfTwo (int n) {
        if (n == 0) return false;
        long x = (long)n;
        return (x&(-x)) == x;
    }
}
