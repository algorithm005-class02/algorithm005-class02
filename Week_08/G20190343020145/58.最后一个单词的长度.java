//不调库函数
class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}

//法2
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int first = s.lastIndexOf(" ");
        if(first == -1)
            return s.length();
        String son = s.substring(first, s.length() - 1);
        return son.length();
    }
}

//法3
public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
}
