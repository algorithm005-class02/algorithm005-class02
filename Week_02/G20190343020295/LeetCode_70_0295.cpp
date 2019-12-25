class Solution {
public:
    // 暴力递归
    //int climbStairs(int n) {
    //    if (1 == n) return 1;
    //    if (2 == n) return 2;
    //    return climbStairs(n-1) + climbStairs(n-2);
    //}

    // 寻找问题的重复性-》 n=n-1 + n-2
    // 将问题抽象化-》斐波那契数列
    // fibonacci 
    int climbStairs(int n) {
        if (n == 1) return 1;
        int head = 1;
        int tail = 2;
        for (int i = 3; i <= n; i++) {
            tail = tail + head;
            head = tail - head;
            /** tail_new = tail_old + head;
             *  head = tail_new - head; ==>> head = tail_old + head - head = tail_old **/       
        }
        return tail;
    }
};