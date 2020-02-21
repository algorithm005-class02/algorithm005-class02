public class Leetcode_74_0065 {

    /* 思路
    标准二分查找算法
    1.原矩阵可理解为一维数组a
    2.取出数组左右序号left = 0, right = m * n - 1
    2.循环
        取数组中间序号mid = left + (right - left) / 2，该序号对应矩阵中的mid行，mid % n列，对应midElement元素。
        midElement将矩阵分为两部分
        比较midElement与target，判断target在哪一部分
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        if (rowLen == 0) return false;
        int colLen = matrix[0].length;

        int left = 0;
        int right = rowLen * colLen - 1;
        int mid, midElement;
        while(left <= right) {
            mid = left + (right - left) / 2;
            midElement = matrix[mid / colLen][mid % colLen];
            if (target == midElement) return true;
            else {
                if (target < midElement) right = mid - 1;
                else left = mid + 1;
            }
        }
        return false;
    }
}
