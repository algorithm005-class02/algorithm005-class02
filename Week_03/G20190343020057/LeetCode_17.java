class Solution {
    //放在外层方便子函数调用
    String[] letterMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};//将对应的字母组合存储为数组，下标和对应的数字键盘对应。
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return result;//字符串对比不能直接==“”
        subF(digits,"",0);
        return result;
    }
    private void subF(String digits,String letters,int index){
        if(index == digits.length()) {
            result.add(letters);//已经到最后一步，将生成的字符串添加到结果数组
            return;
        }
        int num = digits.charAt(index) - '0';
        String numString = letterMap[num];
        for(int i=0;i<numString.length();i++){
            subF(digits,letters+numString.charAt(i),index+1);//在每层加入不同的字母分别进入下一层
        }
        return;
    }
}