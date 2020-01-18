class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k)
    {

        _generate(1,n,k,"");
        return ret;

    }

    //每递归下降一层，k-1，k为0的时候退出
    private void _generate(int start,int n,int k,String input){

        if(k==0){
            String[] answer  = input.split(",");
            List<Integer> aret = Arrays.stream(answer).skip(1).mapToInt(e -> Integer.valueOf(e)).boxed().collect(Collectors.toList());
            ret.add(aret);
            return;
        }
        /
        for(int i=start;i<=n-k+1;i++)
        {
            String newinput = input+","+String.valueOf(i);
            _generate(i+1,n,k-1,newinput);
        }

    }
}