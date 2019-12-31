package algorithm.leetcode.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17_lettercombinations {


    static Map<Character,String> NUM_MAP = new HashMap<>();
    static {
        NUM_MAP.put('2',"abc");
        NUM_MAP.put('3',"def");
        NUM_MAP.put('4',"ghi");
        NUM_MAP.put('5',"jkl");
        NUM_MAP.put('6',"mno");
        NUM_MAP.put('7',"pqrs");
        NUM_MAP.put('8',"tuv");
        NUM_MAP.put('9',"wxyz");
    }




    public List<String> letterCombinations(String digits) {

        List<String> result  = new ArrayList<>();
        placeit(digits,0,"",result);
        return result;

    }

    private void placeit(String digits,int current_digit_idx,String answer,List<String> result) {
        if (current_digit_idx == digits.length())
        {
            result.add(answer);
            return;
        }
        String chars = NUM_MAP.get(digits.charAt(current_digit_idx));
        for(int i=0;i<chars.length();i++){
            char c = chars.charAt(i);
            placeit(digits,current_digit_idx+1,answer+c,result);

        }
    }

    public static void main(String args[]){
        L17_lettercombinations l = new L17_lettercombinations();
        l.letterCombinations("278");
    }

}
