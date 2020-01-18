package com.ming.springboottext;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * leetcode 22题 爱上看代码 学习别人好代码
 */
public class RelatedTopics {
    public List<String> generateParenthesis(int n) {
        generate(0, n * 2, "");
        // generate2(0, 0,n, "");
        return null;

    }

    private void generate(int level, int Max, String s) {
        // 结束
        if (level >= Max) {
            System.out.println(s);
            return;
        }
        // 处理当前层
        String t1 = s + "(";
        String t2 = s + ")";
        // String t3 = s + "-";
        // 下一层
        generate(level + 1, Max, t1);
        generate(level + 1, Max, t2);
        // generate(level + 1, Max, t3);
        //
    }

    // 分析重复后，得出如下条件
    // 左括号 随时加 不要超
    // 右括号 左个数> 右个数
    // 剪掉一些分支

    private void generate2(int left, int right, int n, String s) {
        // 结束
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }
        // 处理当前层
        String t1 = s + "(";
        String t2 = s + ")";
        // 三个重复性:如何用左 如何用右 用完了怎么办?
        // 下一层
        if (left < n)
            generate2(left + 1, right, n, s + "(");
        if (left > right)
            generate2(left, right + 1, n, s + ")");
        //
    }

    public static void main(String[] args) {
        new RelatedTopics().generateParenthesis(2);
    }

}
