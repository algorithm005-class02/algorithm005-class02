package leetcode.week07;

public class LeetCode_51_0069 {
    private int size;
    private int count;

    private void solve (int row, int ld, int rd) {
        System.out.print("row: "+row+",");
        System.out.print("ld: "+ld+",");
        System.out.print("rd: "+rd+" ");
        System.out.println();
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        System.out.println("可以放置皇后的位置"+pos);
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public int totalNQueens (int n) {
        count = 0;
        //在数字没有溢出的前提下，对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方
        //右移一位相当于除2，右移n位相当于除以2的n次方。
        size = (1 << n) -1;//所有可以放皇后的位置 1*2^4-1 = 15
        System.out.println("可以放置皇后的初始位置："+size);
        solve(0, 0, 0);
        return count;
    }

public static void main (String args[]) {
        LeetCode_51_0069 s = new LeetCode_51_0069();
        System.out.println("n=4 时皇后的放置方法共有 ："+s.totalNQueens(4)+"种");
        }

}
