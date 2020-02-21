package algorithm.leetcode.字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class L438_findall {
    public List<Integer> findAnagrams(String s, String p) {
    	
    	
    	List<Integer> ret = new ArrayList<Integer>();
    	if(s==null||p==null||s.length()<p.length()) {
    		return ret;
    	}
    	
    	
    	Map<Character,Integer> pmap = getSignature(p,0,p.length());
    	int slen = s.length();
    	int plen = p.length();
    	for(int i=0;i<=slen-plen;i++) {
    		Map<Character,Integer> windowSig = getSignature(s,i,plen);
    		if(windowSig.equals(pmap)) {
    			ret.add(i);
    		}
    	}
    	return ret;
        
    }

    
    public Map<Character,Integer> getSignature(String s,int start,int length){
    	Map<Character,Integer> signature = new LinkedHashMap<Character,Integer>();
    	for(int i = start;i<start+length;i++) {
    		Character c = s.charAt(i);
    		Integer count = signature.getOrDefault(c, 0);
    		count=count+1;
    		signature.put(c, count);
    	}
    	return signature;
    }
}
