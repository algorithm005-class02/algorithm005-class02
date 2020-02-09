public class Leetcode_191_0065 {
    //解法一：使用位掩码1，与最后一位按位与，判断1的个数
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
                }
           mask <<= 1; //左移一位
        }
        return count;
    }

    //解法二：技巧：将n与n - 1 进行安位与运算，将n的最后一个1置为0，循环执行并增加计数，直到将所有的1置0
//    public int hammingWeight(int n) {
//        int count = 0;
//        while (n != 0) {
//            count++;
//            n &= (n - 1);
//        }
//        return count;
//    }
}
