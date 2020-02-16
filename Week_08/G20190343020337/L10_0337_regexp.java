package algorithm.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

public class L10_regexp {
	
    public boolean isMatch(String s, String p) {
    	
    	return dp(s,p,0,0,new HashMap<String,Boolean>());
        
    }
    
    private boolean dp(String text,String pattern,int i,int j,Map<String,Boolean> memo) {
    	boolean ans = false;
    	if(memo.containsKey(i+"_"+j)) 
    		return memo.get(i+"_"+j);
    	if(j==pattern.length()) return i==text.length();
    	boolean firstmath = (i<text.length()) && ( (pattern.charAt(j)==text.charAt(i)) ||(pattern.charAt(j)=='.'));
    	if((j<=pattern.length()-2)&& pattern.charAt(j+1)=='*') {
    		 ans = dp(text,pattern,i,j+2,memo)||(firstmath && dp(text,pattern,i+1,j,memo));
    	}else
    		 ans = (firstmath && dp(text,pattern,i+1,j+1,memo));
    	memo.put(i+"_"+j, ans);
		return ans;
    	
    	
    }
    
    /**
     * 假设text和pattern是一般字符串的情况下
     * @param text
     * @param pattern
     * @return
     */
    private boolean isMatch_common(String text, String pattern) {
        if (text.length() != pattern.length()) 
            return false;
        for (int j = 0; j < pattern.length(); j++) {
            if (pattern.charAt(j) != text.charAt(j))
                return false;
        }
        return true;
    }
    
    private boolean isMath_common_recursive(String text,String pattern) {
    	if(pattern.equals("")) return text.equals("");
    	boolean first_match = (!text.equals("")) && (pattern.charAt(0)==text.charAt(0));
    	return first_match && isMath_common_recursive(text.substring(1),pattern.substring(1));
    }
    
    private boolean isMath_common_recursive_with_dot(String text,String pattern) {
    	if(pattern.equals("")) return text.equals("");
    	boolean first_match = (!text.equals("")) && (pattern.charAt(0)==text.charAt(0) || pattern.charAt(0)=='.');
    	return first_match && isMath_common_recursive(text.substring(1),pattern.substring(1));
    }
    
    //这是暴力穷举法
    private boolean isMath_common_recursive_with_dot_star(String text,String pattern) {
    	if(pattern.equals("")) 
    		return text.equals("");
    	boolean first_match = (!text.equals("")) && (pattern.charAt(0)==text.charAt(0) || pattern.charAt(0)=='.');
    	if(pattern.length()>=2 && pattern.charAt(1)=='*' ) {
    		//处理*的情况
    		//如果发现有字符和 '*' 结合，
    	    //或者匹配该字符 0 次，然后跳过该字符和 '*'
    	    //或者当 pattern[0] 和 text[0] 匹配后，移动 text
    		return isMath_common_recursive_with_dot_star(text, pattern.substring(2)) || (first_match && isMath_common_recursive_with_dot_star(text.substring(1), pattern));


    	}else
    		return first_match && isMath_common_recursive_with_dot_star(text.substring(1),pattern.substring(1));
    }


    
    
    
    /**
     * # 带备忘录的递归
def isMatch(text, pattern) -> bool:
    memo = dict() # 备忘录
    def dp(i, j):
        if (i, j) in memo: return memo[(i, j)]
        if j == len(pattern): return i == len(text)

        first = i < len(text) and pattern[j] in {text[i], '.'}
        
        if j <= len(pattern) - 2 and pattern[j + 1] == '*':
            ans = dp(i, j + 2) or \
                    first and dp(i + 1, j)
        else:
            ans = first and dp(i + 1, j + 1)
            
        memo[(i, j)] = ans
        return ans
    
    return dp(0, 0)

# 暴力递归
def isMatch(text, pattern) -> bool:
    if not pattern: return not text

    first = bool(text) and pattern[0] in {text[0], '.'}

    if len(pattern) >= 2 and pattern[1] == '*':
        return isMatch(text, pattern[2:]) or \
                first and isMatch(text[1:], pattern)
    else:
        return first and isMatch(text[1:], pattern[1:])

作者：labuladong
链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    
    
    
}
