class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] route = intervals[0];
        for (int[] a : intervals) {
            if (route[1] >= a[0]) {
                route[1] = route[1] > a[1] ? route[1] : a[1];
            } else {
                res.add(route);
                route = a;
            }
        }
        res.add(route);
        return res.toArray(new int[res.size()][]);
    }
}