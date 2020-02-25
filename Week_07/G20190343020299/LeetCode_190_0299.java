public class LeetCode_190_0299 {

    public static void main(String[] args) {

        int res = reverseBits(4);
        System.out.println(Integer.toBinaryString(res).length());
    }

    public static int reverseBits(int n) {
        int ans = 0;
        int bitSize = 31;
        while (n != 0) {
            ans += (n & 1) << bitSize;
            n >>>= 1;
            bitSize--;
        }
        return ans;
    }
}
