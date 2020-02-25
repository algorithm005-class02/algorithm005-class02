class Solution {
public int[][] m
erge(int[][] intervals) {
    List<int[]> result = new ArrayList<>(); //定义一个ArrayList用于存储合并后的区间
    if (intervals == null || intervals.length == 0)
    return result.toArray(new int[0][]);
    //排序intervals
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    int i = 0;
    while (i < intervals.length) {
        int left = intervals[i][0];
        int right = intervals[i][1];

        while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
            i++;
            right = Math.max(right, intervals[i][1]);
        }

        result.add(new int[]{left, right});
        i++;
    }
    return result.toArray(new int[0][]);
}
