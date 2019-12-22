class Solution {
    public int trap(int[] height) {
        //能够承接雨水的条件是某个元素的周边高度大于他的高度
        // 目前此程序没有写对。由于时间紧迫，先提交了。并且，写到后边，我才发现自己一开始的思路错了。
        int sumResult = 0;
        for (int i = 1;i < height.length - 1;i++){
            int before = i;
            int after = i;
            while(before > 0 && height[before -1] >= height[before]) before--;
            while(after < height.length -1 && height[after + 1]>= height[after])after++;
            if (before < i && after > i){
                int minHeight = Math.min(height[before],height[after]);
                while(height[before +1] >= minHeight)before ++;
                while(height[after -1] >= minHeight) after --;
                int tempResult = (after - before -1)*minHeight;
                int tempResult2 = 0;
                before ++;
                after --;
                for (;before <= after;before++){
                    tempResult2 +=height[before];
                }
                int result = tempResult - tempResult2;
                sumResult += result;
            }
        }
        return sumResult;
    }
}