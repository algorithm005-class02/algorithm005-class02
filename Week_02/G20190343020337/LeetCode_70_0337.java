class Solution {

    public static Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    public int climbStairs(int n) {

        if(n<=1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }
        int n_1=climbStairs(n-1);
        int n_2=climbStairs(n-2);
        map.put(n,n_1+n_2);
        return n_1+n_2;

    }
}