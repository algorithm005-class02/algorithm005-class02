import java.util.ArrayList;
import java.util.List;

class Solution {
    private ArrayList<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        generateMethod(0, 0, n,"");
        return result;

    }

    private void generateMethod(int left, int right,int n, String s) {
        //teminator 终结者
        //filter invalid s
        //left 随时加，确保不超标
        // right 必须之前有左括号，左个数>右个数
        if ( left == n && right == n) {
            result.add(s);
            System.out.println(s);
            return;
        }

        //process current logic: left, right

        //drill down 下探到下一层
        if(left < n)
        generateMethod(left + 1, right, n,s + "(");

        if(left > right)
        generateMethod(left,right + 1,n, s + ")");


        //reverse status 清理当前层
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generateParenthesis(3));
    }
}