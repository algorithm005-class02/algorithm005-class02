public class Solution {
    int count = 0;
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        helper(n);
        return count;
    }

    public void helper(int n){
        if(n == 0){
            return;
        }
        count += 1;
        hammingWeight(n & (n-1));
    }
}