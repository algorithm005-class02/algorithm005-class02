/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */
/* 
本题中中学到的知识点：
(1)char字符型数字:'4',转换为int型数字:4  方法是：'4'-'0'即可
（2）Math.pow(double a,double b)函数返回的是一个double型的数据。
（3）字符串: "    "是有长度的，几下空格，长度就是几。
（4）空字符串的长度是0,即：""
 */
// @lc code=start
class Solution {
    public int myAtoi(String str) {
        char[] nums = new char[str.length()];
        int index = 0;
        long result = 0L;
        if (str.length() == 0) {
            return 0;
        } else {//将字符串中的数字和正负号提取出来
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    nums[index++] = str.charAt(i);
                } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                    if (index == 0) {//只有在首位是正负号时才要
                        nums[index++] = str.charAt(i);
                    } else {
                        break;//如果是之后出现的正负号就不要了，跳出循环。
                    }
                } else if (str.charAt(i) == ' ') {
                    if (index != 0) {//如果是后续再出现空格的话就跳出循环
                        break;
                    } else {//只有在前面出现空格时才接着往下看
                        continue;
                    }
                } else {
                    break;
                }
            }
        }
        if (index == 0) {//对应样例：""
            return 0;
        } else if (index == 1) {//对应样例："3"以及"+/-"
            if (nums[0] == '+' || nums[0] == '-') {
                return 0;//"+/-"
            } else {
                return nums[0] - '0';//"3"
            }
        } else {
            if (nums[0] != '+' && nums[0] != '-') {//对应样例：897
                for (int i = 0; i < index; i++) {
                    int jiecheng = (int) Math.pow(10, index - 1 - i);
                    int num = nums[i] - '0';
                    result = (long) result + (num * (long) jiecheng);
                }
                if (result > 2147483647) {
                    return 2147483647;
                } else {
                    return (int) result;
                }
            } else if (nums[0] == '+') {//对应样例：+987
                for (int i = 1; i < index; i++) {
                    int jiecheng = (int) Math.pow(10, index - 1 - i);
                    int num = nums[i] - '0';
                    result = (long) result + (num * (long) jiecheng);
                }
                if (result > 2147483647) {
                    return 2147483647;
                } else {
                    return (int) result;
                }
            } else if (nums[0] == '-') {//对应样例：-987
                for (int i = 1; i < index; i++) {
                    int jiecheng = (int) Math.pow(10, index - 1 - i);
                    int num = nums[i] - '0';
                    result = (long) result + (num * (long) jiecheng);
                }
                if (-result < -2147483648) {
                    return -2147483648;
                } else {
                    return (int) -result;
                }
            }
        }
        return 1;
    }
}
// @lc code=end
/* 
思路：拿到题目由于题目较长，着实理解了好一会；但是很快就理清了思路：
首先输入是一个字符串；将其转换为整数，但是真正对我们有用的其实只有两种字符：'0'-'9'以及'+'和'-'
很朴素的思路就是将原字符串中对我们有用的部分提取出来放到一个存储数组中。
此处，开辟数组的长度有技巧：就是开辟字符串长度的数组空间大小；开大了吧空间复杂度太高，
开小了吧部分较长的样例字符串放不进去，会爆出数组下标越界的异常。
然后将字符串中的元素提取出来：对应位置处乘以相应的10阶乘转换为整数。
（1）只有在0-9之间的数字，以及+，-我们才需要
（2）提取正负号时，该正负号只能是第一个出现在提取数组中的，即后续再出现的话就不要了，跳出循环了
避免样例：-9+ 的存在
（3）一开始会遇到空格，那么就跳过，但是如果在存储数组中已经有元素了，即此时index!=0的情况下，又出现
空格，则跳出循环（放弃后面的字符串）。即避免样例："   +1  12"，对与这样的样例只需要提取到+1即可。
特殊情况考虑：
（1）一开始字符串为空：直接返回0
（2）存储数组只有一个元素：需要判断是正负号还是数字

*/