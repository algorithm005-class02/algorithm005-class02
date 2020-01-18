class Solution{
    List<String> ret = new ArrayList<>();

    public List<String> generateParenthesis(int n)
    {
        int left=0,right=0;
        _generate(left,right,n,"");
        return ret;

    }

    private void _generate(int left, int right, int n, String s) {
        if(left==n&&right==n){
            ret.add(s);
            return;
        }

        if(left<n){
            _generate(left+1,right,n,s+"(");
        }
        if(left>right){
            _generate(left,right+1,n,s+")");
        }
    }
}


/*** 这是我没看视频 人肉递归出来的结果。
class Solution {
    static char left_brackets  = '(';
    static char right_brackets = ')';
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int number)
    {
        _generate(0,2*number,"");
        return result;
    }

    private void _generate(int level,int max,String previos){

        if(level>=max){
            if(isvalid(previos))
                result.add(previos);
            return;
        }
        _generate(level+1,max,previos+"(");
        _generate(level+1,max,previos+")");
    }

    private boolean isvalid(String s){
        if((s.charAt(0)==right_brackets)||s.charAt(s.length()-1)==left_brackets)
        {
            return false;
        }
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==left_brackets)
                sum=sum+1;
            else
                sum=sum-1;
            if(sum<0)
                return false;
        }
        if(sum!=0)
            return false;
        return true;
    }
}
 ***/