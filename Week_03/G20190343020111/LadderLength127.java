package com.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:
如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class LadderLength127 {

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		ArrayList<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		int x = new LadderLength127().ladderLength2(beginWord, endWord, wordList);
		System.out.println(x);

	}

	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
		int level = 0;
		int L = beginWord.length();
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		for (String string : wordList) {
			ArrayList ar = null;
			for (int i = 0; i < L; i++) {
				String newWord = string.substring(0, i) + '*' + string.substring(i + 1, L);
				if (hm.containsKey(newWord)) {
					hm.get(newWord).add(string);
				} else {
					ar = new ArrayList();
					ar.add(string);
					hm.put(newWord, ar);
				}
			}
		}

		Queue<Pair<String, Integer>> que = new LinkedList<>();
		que.add(new Pair(beginWord, 1));

		while (!que.isEmpty()) {
			Pair p = que.remove();
			String node = (String) p.getKey();
			level = (Integer) p.getValue();
			for (int i = 0; i < L; i++) {
				String newWord = node.substring(0, i) + '*' + node.substring(i + 1, L);
				ArrayList<String> arr = hm.get(newWord);
				if (arr != null) {
					for (String string : arr) {
						if (string.equals(endWord)) {
							return ++level;
						}
						que.add(new Pair<String, Integer>(string, level + 1));
					}
				}
			}
		}

		return level;
	}

}
