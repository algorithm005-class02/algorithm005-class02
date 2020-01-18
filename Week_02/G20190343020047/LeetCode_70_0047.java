class Solution {
    // public int climbStairs(int n) {
    //     Map<Integer, Integer> solveList = new HashMap<Integer, Integer>();
    //     return helper(n, solveList);
    // }

    // public int helper(int n, Map<Integer, Integer> solveList) {
    //     if (n <= 2) {
    //         return n;
    //     }
    //     if (solveList.containsKey(n)) {
    //         return solveList.get(n);
    //     }
    //     int ret = helper(n - 1, solveList) + helper(n - 2, solveList);
    //     solveList.put(n, ret);
    //     return ret;
    // }

    public int climbStairs(int n) {
        if(n < 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        int[] store = new int[n];

        store[0] = 1;
        store[1] = 2;

        for(int i = 2; i < n; ++i) {
            store[i] = store[i-1] + store[i-2];
        }

        return store[n-1];
    }
}