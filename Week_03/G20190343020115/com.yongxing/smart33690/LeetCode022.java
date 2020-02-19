package smart33690;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class LeetCode022 {
    public static void main(String[] args) {
        LeetCode022 leetCode022 = new LeetCode022();
        List<String> res = leetCode022.generateParenthesis(3);
        for(int i=0;i<res.size();i++) {
            System.out.println(res.get(i));
        }
    }
    List result ;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        generate(0,0,n,"");
        return result;
    }
    private void generate(int l,int r,int n,String s){
        if(l ==n && r == n) {
            result.add(s);
            return;
        }
        if(l < n){
            generate(l+1,r,n,s+"(");
        }
        if(l > r){
            generate(l,r+1,n,s+")");
        }
    }



}
