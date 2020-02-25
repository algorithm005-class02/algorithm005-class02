import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * 爬楼梯及其变形
 * https://leetcode.com/problems/climbing-stairs/
 */
public class Leetcode_70_climbingStairs {
    /**
     * 原始版本：每次只能爬1或2个台阶
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     * 变形1：每次可以爬1、2 或 3个台阶
     */
    public int climbStairs2(int n) {
        if (n <= 3) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3, f4 = 6;
        for (int i = 4; i <= n; i++) {
            f4 = f1 + f2 + f3;
            f1 = f2;
            f2 = f3;
            f3 = f4;
        }
        return f4;
    }


    /**
     * 变形2：每次可以爬1、2 或 3个台阶，且相邻两步的步伐不能相同
     */
    public int climbStairs3(int n) {
        List<List<Integer>> list1 = asList(asList(1));
        List<List<Integer>> list2 = asList(asList(2));
        List<List<Integer>> list3 = asList(asList(1, 2), asList(2, 1), asList(3));

        for (int i = 4; i <= n; i++) {
            List<List<Integer>> tmpList = new ArrayList<>();
            addToTmpList(list1, tmpList, 3);
            addToTmpList(list2, tmpList, 2);
            addToTmpList(list3, tmpList, 1);
            list1 = list2;
            list2 = list3;
            list3 = tmpList;
        }
        return list3.size();
    }

    private void  addToTmpList(List<List<Integer>> list, List<List<Integer>> newList, int suffix) {
        for (List<Integer> ss : list) {
            if (ss.get(ss.size() - 1) != suffix) {
                newList.add(new ArrayList<>(ss));
                newList.get(newList.size() - 1).add(suffix);
            }
        }
    }

    public static void main(String[] args) {
        long timeBegin = System.currentTimeMillis();
        Leetcode_70_climbingStairs solution = new Leetcode_70_climbingStairs();
        System.out.println(solution.climbStairs3(15));
        System.out.println(System.currentTimeMillis() - timeBegin + " ms");
    }
}
