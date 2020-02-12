class Solution {
    public boolean isPowerOfTwo(int n) {
        // int mi = 1;  //2的0次方
        // while(n > mi){
        //     mi *= 2;
        // }
        // if(n==mi) return true;
        // return false;
        
        //2的幂次对应的2进制只有1个1.
        if(n<=0) return false;
        int x = n & (n-1);
        return x==0;

    }
}