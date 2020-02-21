package algorithm.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

public class L242_isanagram {
    public boolean isAnagram(String s, String t) {
    	
    	if(s==null||t==null||s.length()!=t.length()) {
    		return false;
    	}
    	Map<Character,Integer> ssignature  = getSignature(s);
    	Map<Character,Integer> tsignature  = getSignature(t);
    	return ssignature.equals(tsignature);
    	
    	
    	
        
    }
    
    public Map<Character,Integer> getSignature(String s){
    	Map<Character,Integer> signature = new HashMap<Character,Integer>();
    	for(int i = 0;i<s.length();i++) {
    		Character c = s.charAt(i);
    		Integer count = signature.getOrDefault(c, 0);
    		count=count+1;
    		signature.put(c, count);
    	}
    	return signature;
    }
}
