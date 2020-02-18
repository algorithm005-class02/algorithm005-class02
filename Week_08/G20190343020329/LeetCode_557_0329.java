//557. 反转字符串中的单词 III
class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] s1 = s.split(" ");
        for(int i = 0; i <= s1.length - 1; i++){
            char[] data = s1[i].toCharArray();
            for (int j = data.length - 1; j >= 0; j --) {
                ans.append(data[j]);
            }
            ans.append(" ");
        }
        //去掉最后添加上的空格
        return ans.toString().trim();
    }
}