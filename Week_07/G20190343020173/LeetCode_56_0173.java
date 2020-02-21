package org.crayzer.leetcode.editor.en.sort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_56_MergeIntervals {

    class Interval {
        int start;
        int end;

        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    class Solution {

        private class IntervalComparator implements Comparator<Interval> {
            @Override
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        }

        public int[][] merge(int[][] intervals) {
            List<Interval> intervalsList = new LinkedList<>();
            for (int[] interval : intervals) {
                intervalsList.add(new Interval(interval));
            }
            intervalsList.sort(new IntervalComparator());

            LinkedList<Interval> merged = new LinkedList<>();
            for (Interval interval : intervalsList) {
                if (merged.isEmpty() || merged.getLast().end < interval.start) {
                    merged.add(interval);
                } else {
                    merged.getLast().end = Math.max(merged.getLast().end, interval.end);
                }
            }

            int i = 0;
            int[][] result = new int[merged.size()][2];
            for (Interval mergedInterval : merged) {
                result[i] = mergedInterval.toArray();
                i++;
            }
            return result;
        }
    }
}
