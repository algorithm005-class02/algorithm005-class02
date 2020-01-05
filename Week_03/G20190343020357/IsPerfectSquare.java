package week03.binarySearch;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {

        if (num < 2) return true;
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num == mid * mid) return true;
            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
