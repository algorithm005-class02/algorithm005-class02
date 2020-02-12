class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (right >= intervals[i][0]) {
                right = right > intervals[i][1] ? right : intervals[i][1];
            } else {
                res.add(new int[] {left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.add(new int[] {left, right});
        return res.toArray(new int[0][]);
    }
}
