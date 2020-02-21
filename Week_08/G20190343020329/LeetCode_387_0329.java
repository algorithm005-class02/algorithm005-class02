//387. 字符串中的第一个唯一字符
class Solution {
    public int firstUniqChar(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        char[] data = s.toCharArray();
        for (char c : data) {
            Integer number = map.get((int) c);
            if (null == number) {
                number = 0;
            }
            number ++;
            map.put((int) c, number);
        }
        for (int i = 0; i < data.length; i ++) {
            Integer number = map.get((int)data[i]);
            if (null != number && 1 == number) {
                return i;
            }
        }
        return -1;
    }
}