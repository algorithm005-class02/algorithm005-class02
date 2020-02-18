package algorithm.leetcode.高级动态规划;

public class L746_minCostClimbingStairs {
	
    public int minCostClimbingStairs(int[] cost) {
    	int n = cost.length+1;
    	int dp[] = new int[n];
    	
    	//dp[i] = min( dp[i-1],dp[i-2]+cost[i])
    	dp[0] = cost[0];
    	dp[1] = cost[1];
    	for(int i=2;i<n;i++) {
    		dp[i] = Math.min( dp[i-1],dp[i-2])+cost[i];
    	}
        return Math.min(dp[n-1], dp[n-2]);
    }
    
    public static void main(String args[]) {
    	int[] cost = new int[] {0,0,1,1};
    	L746_minCostClimbingStairs l = new L746_minCostClimbingStairs();
    	l.minCostClimbingStairs(cost);
    }

}
