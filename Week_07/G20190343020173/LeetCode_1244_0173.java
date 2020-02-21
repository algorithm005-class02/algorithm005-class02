package org.crayzer.leetcode.editor.en.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1244_DesignALeaderboard {

    class Leaderboard {

        Map<Integer, Integer> ranking;

        public Leaderboard() {
            ranking = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            ranking.put(playerId, ranking.getOrDefault(playerId, 0) + score);
        }

        public int top(int K) {
            return ranking.values()
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(K)
                    .mapToInt(i -> i)
                    .sum();
        }

        public void reset(int playerId) {
            ranking.remove(playerId);
        }
    }
}
