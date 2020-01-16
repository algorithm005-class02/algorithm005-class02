class Solution {

    //方法1：考察当前位置能否储存水
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        //从第1个开始，第0个不可能有结果，最后一个不可能有结果
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = height[i], max_right = height[i];
            for (int j = i - 1; j >= 0; j--) { //左边最大的bar
                max_left = Math.max(max_left, height[j]);
            }
            //不可能产生结果的情况
            if (max_left <= height[i]) {
                continue;
            }

            for (int j = i + 1; j < size; j++) { //右边最大的bar
                max_right = Math.max(max_right, height[j]);
            }
            //不可能产生结果的情况
            if (max_right <= height[i]) {
                continue;
            }
            ans += Math.min(max_left, max_right) - height[i];
            //System.out.println(i+" "+(Math.min(max_left, max_right) - height[i]));
        }
        return ans;
    }
}