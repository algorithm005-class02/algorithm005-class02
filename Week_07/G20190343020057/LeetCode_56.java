class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));//按区间起点进行排序
        
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];

        for(int[] interval : intervals){
            if(interval[0] <= newInterval[1]){//每段区间的起点小于等于上一段的终点
                newInterval[1] = Math.max(interval[1],newInterval[1]);//更新一份终点，取最大值
            }else{
                result.add(newInterval); 
                newInterval = interval;
            }
        }
        result.add(newInterval);//增加最后1个区间
        return result.toArray(new int[result.size()][2]);
    }
}