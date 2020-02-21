class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] res= new int[amount+1];
        for(int i = 0; i < amount+1; i++){
            int min = amount + 1;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] < 0) continue;
                else if(i - coins[j] == 0){
                    min = 1;
                    continue;
                }
                if(res[i - coins[j]] < 1) continue;
                min = min < res[i-coins[j]] + 1 ? min : res[i-coins[j]] + 1;
            }
            if(min == amount + 1) res[i] = -1;
            else res[i] = min;
        }
        res[0] = 0;
        return res[amount];
    }
}
