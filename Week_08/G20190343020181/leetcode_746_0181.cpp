class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int f1 = cost[0], f2 = cost[1];
        for (int i = 2; i < cost.size(); i++) {
            int temp = f2;
            f2 = min(f1, f2) + cost[i];
            f1 = temp;
        }
    return min(f1, f2);
    }
};