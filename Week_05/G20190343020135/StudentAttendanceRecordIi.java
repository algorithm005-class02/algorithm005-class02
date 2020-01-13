//给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。 
//
// 学生出勤记录是只包含以下三个字符的字符串： 
//
// 
// 'A' : Absent，缺勤 
// 'L' : Late，迟到 
// 'P' : Present，到场 
// 
//
// 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 8 
//解释：
//有8个长度为2的记录将被视为可奖励：
//"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
//只有"AA"不会被视为可奖励，因为缺勤次数超过一次。 
//
// 注意：n 的值不会超过100000。 
// Related Topics 动态规划


package leetcode.editor.cn;
public class StudentAttendanceRecordIi{
    public static void main(String[] args) {
        Solution solution = new StudentAttendanceRecordIi().new Solution();
        int i = solution.checkRecord(2);
        System.out.println(i);
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    long M = 1000000007;
    public int checkRecord(int n) {
        long[] f = new long[n <= 5 ? 6 : n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;
        for (int i = 4; i <= n; i++)
            f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M;
        long sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return (int)(sum % M);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
    