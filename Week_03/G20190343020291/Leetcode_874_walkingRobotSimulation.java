import java.util.HashSet;
import java.util.Set;

/**
 * 模拟机器人行走
 * https://leetcode.com/problems/walking-robot-simulation/
 */
public class Leetcode_874_walkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] cord = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstaclesSet.add(obs[0] + "," + obs[1]);
        }

        int x = 0, y = 0;
        int curCord = 0;
        int maxDistance = 0;

        for (int command : commands) {
            if (command == -2) {
                curCord = (curCord + 3) % 4;
            } else if (command == -1) {
                curCord = (curCord + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int newX = x + cord[curCord][0];
                    int newY = y + cord[curCord][1];
                    if (obstaclesSet.contains(newX + "," + newY)) {
                        break;
                    }
                    x = newX;
                    y = newY;
                }
                maxDistance = Math.max(maxDistance, x*x + y*y);
            }
        }
        return maxDistance;
    }
}
