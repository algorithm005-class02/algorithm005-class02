package leetcode.week07;

public class LeetCode_191_0069 {
    public static void main (String args[]) {
        System.out.println (hammingWeight (00000000000000000000000000001011));
    }

    public static int hammingWeight (int n) {
        int sum = 0;
        while (n != 0) {
            sum ++;
            n &= (n - 1);
        }
        return sum;
    }
}
