public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            count ++;
            //去掉最低位的一
            n &=(n-1);
        }
        return count;
    }
}