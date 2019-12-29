package com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * @author ibing
 *
 */
public class GroupAnagrams49 {

	public static void main(String[] args) {
		
		String strs[]= {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams2(strs));
	}
	//方法1：对每个元素进行排序后放入hash表中，排序后的元素充当key，key相同归为一类
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashmap= new HashMap<String,List<String>>();
        for (int i = 0; i < strs.length; i++) {
        	char c[]=strs[i].toCharArray();
        	Arrays.sort(c);
			String key=String.valueOf(c);
			if (hashmap.containsKey(key)) {
				hashmap.get(key).add(strs[i]);
			}else {
				List<String> l=(List<String>)new ArrayList<String>();
				l.add(strs[i]);
				hashmap.put(key, l);
			}
		}
        System.out.println(hashmap);
		return null;
    }
	//方法2：通过计算每个元素的ASCII码得到一个key，key相同归为一类
	public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,List<String>> hashmap= new HashMap<String,List<String>>();
        int[] hash=new int[26];
        
        for (int i = 0; i < strs.length; i++) {
        	Arrays.fill(hash, 0);
        	for (char x : strs[i].toCharArray()) {
				hash[x-'a']++;
			}
        	StringBuffer sb= new StringBuffer();
        	for (int y : hash) {
				sb.append(y);
			}
        	String key=sb.toString();
        	
			if (hashmap.containsKey(key)) {
				hashmap.get(key).add(strs[i]);
			}else {
				List<String> l=(List<String>)new ArrayList<String>();
				l.add(strs[i]);
				hashmap.put(key, l);
			}
		}
        System.out.println(hashmap);
		return null;
    }
}
