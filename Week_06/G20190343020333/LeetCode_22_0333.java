class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        int left = 1;
        int right = 0;
        String temp = "(";
        helper(n,left,right,temp);
        return res;
    }

    public void helper(int n,int left,int right,String temp){
        if(temp.length() == 2*n)
            res.add(temp);
        if(left < n && left >= right)
            helper(n,left+1,right,temp+"(");
        if(right < n && right <= left)
            helper(n,left,right+1,temp+")");
    }
}