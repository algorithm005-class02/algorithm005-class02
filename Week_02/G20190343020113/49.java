/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length < 1)
            return new ArrayList();
        Map<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String res = String.valueOf(chars);
            if (map.containsKey(res)) {
                map.get(res).add(str);
            } else {
                map.put(res, new ArrayList<>());
                map.get(res).add(str);
            }
        }
        return new ArrayList(map.values());
    }
}