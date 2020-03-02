package G20190343020095;

/**
 *  * @author jiangli
 *  * @date 2020/2/29 21:16
 *  * @description
 *  
 */
public class LeetCode_58_0097 {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int count = 0;
        for(int i = chars.length-1;i>=0;i--){
            if(chars[i] == ' '){
                return count;
            }else {
                count++;
            }
        }
        return count;
    }
}
