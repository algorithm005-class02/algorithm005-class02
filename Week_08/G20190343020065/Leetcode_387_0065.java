public class Leetcode_387_0065 {
    public int firstUniqChar(String str) {
        //1.构造HashMap
        HashMap<Character, Integer> number = new HashMap<Character, Integer>();

        //2.遍历str，将每个字符出现的次数保存到HashMap中
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            number.put(c, number.getOrDefault(c, 0) + 1);
        }
        //3.查找HashMap中第一个value为1的数
        for(int j = 0; j < str.length(); j++) {
            if (number.get(str.charAt(i)) == 1)
            return i;
        }

        return -1;
    }
}
