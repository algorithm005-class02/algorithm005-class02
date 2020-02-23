package smart33690;

import java.util.ArrayList;
import java.util.List;

/**
 * 位1的个数
 */
public class LeetCode191 {
    public static void main(String[] args) {

        int res = hammingWeight(00000000000000000000000000001011);
        System.out.println(res);
    }


    public static int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

}
