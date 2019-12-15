package Array;/**
 * author: Ziv
 * description:
 * Date:Created in
 */


/**
 *
 *
 * @author piper
 * @date 2019/12/10 21:39 
 * @decrisption
 *
 * //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * //
 * // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * //
 * // 注意：给定 n 是一个正整数。
 * //
 * // 示例 1：
 * //
 * // 输入： 2
 * //输出： 2
 * //解释： 有两种方法可以爬到楼顶。
 * //1.  1 阶 + 1 阶
 * //2.  2 阶
 * //
 * // 示例 2：
 * //
 * // 输入： 3
 * //输出： 3
 * //解释： 有三种方法可以爬到楼顶。
 * //1.  1 阶 + 1 阶 + 1 阶
 * //2.  1 阶 + 2 阶
 * //3.  2 阶 + 1 阶
 * //
 * // Related Topics 动态规划
 */
public class LeetCode_70__0249 {
    public static void main(String[] args) {
        LeetCode_70__0249 test = new LeetCode_70__0249();
        int climbStairs = test.climbStairs(4);
        System.out.println(climbStairs);
    }
    public int climbStairs(int n) {
        if(n == 0 || n == 1|| n == 2) return n;
        int men[] = new int[n];
        men[0] = 1;
        men[1] = 2;
        for(int i = 2; i < n; i++){
            men[i] = men[i-2] + men[i-1];
        }
        return men[n-1];
    }
}
