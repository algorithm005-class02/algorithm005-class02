import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> res = new ArrayList<>();
        int[] newIntervals = intervals[0];
        res.add(newIntervals);
        for (int[] interval : intervals) {
            if (newIntervals[1] >= interval[0]) {
                newIntervals[1] = Math.max(newIntervals[1], interval[1]);
            } else {
                res.add(interval);
                newIntervals = interval;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

