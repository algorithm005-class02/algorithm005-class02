//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n == 0) return res;//特殊情形：棋盘为空时，直接返回空列表。
        char[][] Nqueen = new char[n][n];
        for (int i = 0; i < n; i++) {  //初始化一个n*n的棋盘，一开始全部是‘.’
            for (int j = 0; j < n; j++) {
                Nqueen[i][j] = '.';
            }
        }
        backtrace(0, n, Nqueen, res);
        return res;
    }

    public boolean isvalid(int row, int col, int n, char[][] Nqueen) {
        for (int i = 0; i < row; i++) {//判断当前行前面所有行的同一列col上是否有皇后冲突
            if (Nqueen[i][col] == 'Q') return false;
        }
        //为什么只需要判断左上方和右上方对角线上的元素呢？换言之：为啥不需要判断左下方和右下方的呢？
        //原因：
        //我们是逐层的下探，只需要判断当前行以前的行左上方以及右上方的对角线上是否有元素冲突，当前行以下的行还没有被下探到
        for (int i = row - 1, j = col - 1; i >= 0 & j >= 0; i--, j--) {//判断当前位置的左上方对角线上是否有皇后冲突
            if (Nqueen[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {//判断当前位置的右上方的对角线上是否有皇后冲突
            if (Nqueen[i][j] == 'Q') return false;
        }
        return true;//当前位置符合可以放置皇后的条件
    }

    private void backtrace(int row, int n, char[][] NQueen, List<List<String>> res) {
        if (row == NQueen.length) {//已经下探到达最底层了
            //下面的处理技巧:将char[][]二维字符数组转换成为List<String>列表类型的方法：
            List<String> ans = new ArrayList<>();
            for (char[] hang : NQueen) {//取二维字符数组的第一维，转换为一个字符串类型，添加到List<String>中去
                ans.add(new String(hang));
            }
            res.add(ans);//添加到最终结果集中
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isvalid(row, col, n, NQueen)) {//当前位置（row,col）条件符合,isvalid函数返回true
                NQueen[row][col] = 'Q';//将当前位置上原先的‘.’改为’Q‘
                backtrace(row + 1, n, NQueen, res);//下探到下一层
                NQueen[row][col] = '.';//撤销选择，将当前位置上的‘Q’还原成为‘.’
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
/*
解法一：首先我们先来看一下什么是回溯：
       1.回溯理解：
       一个完整的回溯算法应该包含三步骤：DFS+状态重置+剪枝
       代码模板：
       for i:0-->n:
            条件满足;//剪枝操作，不满足条件的：不做出选择。
            做出选择;
            下探到下一层;
            撤销选择;
       即对于一个本题中的皇后放置问题，判断当前位置上是否可以可以放置皇后，可以则做出选择，不可以则隐含的是剪枝操作

       2.分治理解：就是将原先的问题规模逐渐变小，由局部小问题的得到解决，从而导致最终大问题的解决
       3.递归理解：是原先的问题具有重复性，操作完最基础的情形，后续的每一步，都是重复之前的操作

解法二：维护三个哈希表HashSet，利用HashSet中元素的无重复性，分别记录当前行位置的
       同一列col上是否有皇后冲突；以及当前位置的右上方的对角线salve，和左上方的
       对角线上master是否有元素冲突。
*      List<List<String>> res = new ArrayList<List<String>>();

        if (n == 0) {//特殊情形：棋盘为空时，返回的是一个空列表
            return res;
        }
        Set<Integer> master = new HashSet<>();//主对角线上记录皇后位置
        Set<Integer> salve = new HashSet<>();//副对角线上记录皇后的位置
        Stack<Integer> stack = new Stack<>();//记录在一行做选择时，在栈中存储正确的皇后位置在当前行的索引下标
        Set<Integer> col = new HashSet<>();//同一列上的记录皇后的位置
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        backtrace(nums, 0, n, col, master, salve, stack, res);
        return res;

    }

    public List<String> covet2List(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
            sb.replace(num, num + 1, "Q");将当前符合条件的nums[i]位置上的元素替换为‘Q’
            board.add(sb.toString());//将当前替换好了的StringBuilder对象转换成字符串，并压入List<String>中
        }
        return board;
    }

    private void backtrace(int[] nums, int row, int n,
                           Set<Integer> col,
                           Set<Integer> master,
                           Set<Integer> salve,
                           Stack<Integer> stack,
                           List<List<String>> res) {
        if (row == n) {//下探到了最底层（即棋盘的最后一行都已经做完选择了）
            List<String> middle = covet2List(stack, n);
            res.add(middle);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !master.contains(row+i) && !salve.contains(row-i)) {//当前位置放置皇后的前提条件：
            //同一列上不存在皇后，主对角线上以及副对角线上均不存在皇后。
                stack.add(nums[i]);//将这个位置记录下来，后续利用convert2List函数将对应位置nums[i]上的元素由‘.’替换成‘Q’
                //做出选择：
                col.add(i);//这一列记录下来
                master.add(row + i);//主对角线记录下来
                salve.add(row - i);//副对角线记录下来
                //下探到下一层：
                backtrace(nums, row + 1, n, col, master, salve, stack, res);//下探到下一层
                //撤销选择：
                salve.remove(row - i);
                master.remove(row + i);
                col.remove(i);
                stack.pop();
            }
        }
* */


