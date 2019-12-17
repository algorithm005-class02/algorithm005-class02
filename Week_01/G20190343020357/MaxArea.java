package week01;

public class MaxArea {

    //1 枚举，leftBar rightBar  area=(rightBar-leftBar)*heightDiff
    //O(n^2)
    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                //cal area;
                int temp = calArea(height, i, j);
                area = Math.max(temp, area);
            }
        }
        return area;
    }


    public static int calArea(int[] height, int i, int j) {
        int area = (j - i) * Math.min(height[i], height[j]);
        return area;
    }

    //左右边界，i，j，向中间收敛:左右夹逼
    //O(n)
    public static int maxArea2(int[] height) {
        int area = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int areaTemp = minHeight * (j - i + 1);
            area = Math.max(area, areaTemp);
        }
        return area;
    }


    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea2(height));

    }
}
