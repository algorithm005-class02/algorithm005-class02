import java.util.*;

/**
 * 解题思路：
 * 1.排序数组分类（哈希表），维护一个映射map : {String -> List}，时间复杂度：O(NKlogK)
 * 2.按计数分类，时间复杂度：O(NK)
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution49{

    //初始化key="#0#0#0#0",数字代表abcd出现的次数，用#分割
    //time complexity:O(NK)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder stringBuffer = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                stringBuffer.append("#").append(count[i]);
            }
            String key = stringBuffer.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }


    //将遍历的字符串中的字母排序存储为map的key，若是key相等则将字符串添加的List
    //time complexity:O(NKlogK)，N指strs的长度，K是指strs中字符串的长度，外部循环O(n)+排序字符串O(nlogn)
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)