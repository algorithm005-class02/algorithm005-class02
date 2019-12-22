class Solution {
    public int climbStairs(int n) {
        return climb(n, 0);
    }

    public int climb(int totalNum, int currentStep) {
        if (totalNum == currentStep) {
            return 1;
        }
        if (totalNum < currentStep) {
            return 0;
        }
        
        return climb(totalNum, currentStep + 2) + climb(totalNum, currentStep + 1);
    }
}