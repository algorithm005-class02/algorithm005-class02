/**
 * @method "排序数组分类法"
 * @explain 当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
 * @complexity 时间复杂度：O(NKlogK),空间复杂度：O(NK)
 * @param {string[]} strs
 * @return {List<List<String>>}
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        // 1.建立一个哈希盒子
        Map<String,List> box = new HashMap<String,List>(); 
        for (String s : strs) {
            // 2.把数组的每个字符串遍历出来取出当个字符
            char[] ch = s.toCharArray();
            // 3.把每个字符进行排序
            Arrays.sort(ch);
            // 4.把排序好的字符从新转化为字符串，并作为box的key
            String key = String.valueOf(ch);
            if (!box.containsKey(key)){
                // 5.如果box不包含这个key则新建一个
                box.put(key,new ArrayList());
            } 
            // 6.按照字符串根据自身提取出来的key来分组装到box中
            box.get(key).add(s);
        }
        // 7.去掉映射的key只留下分组好的数组添加到新建的List返回
        return new ArrayList(box.values());
    }
}
