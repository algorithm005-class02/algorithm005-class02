//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        backtrace("", digits, 0, res, map);
        return res;
    }

    public void backtrace(String result, String digits, int level, List<String> res, HashMap<Character, String> map) {
        if (level == digits.length()) {//到最底层了，
            res.add(result);
            return;
        }
        String letter = map.get(digits.charAt(level));
        for (int i = 0; i < letter.length(); i++) {
            backtrace(result + letter.charAt(i), digits, level + 1, res, map);//下探到下一层：即下一个数字
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
