class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "." + obstacle[1]);
        }
        
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, x = 0, y = 0, result = 0;
        for (int c : commands) {
            if (c == -1) { // turn right
                d++;
                if (d == 4) d = 0; // reset counter
            } else if (c == -2) { // turn left
                d--;
                if (d == -1) d = 3;
            } else {
                while (c-- > 0 && !set.contains((x + dirs[d][0]) + "." + (y + dirs[d][1]))) {
                    // move step by step!!!!!!
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}