package week03.binarySearch;

public class MySqrt {
    public static int mySqrt(int x) {
        if (x == 1 || x == 0) return 1;
        int left = 1;
        int right = x;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static int mySqrt1(int x) {
        if (x == 0 || x == 1) {
            return 1;
        }
        int s = x;

        return (int) helper(x, s);
    }

    public static double helper(double x, int s) {
        double e = (x + s / x) / 2;
        if (e == x) {
            return x;
        } else {
            return helper(e, s);
        }
    }


    public static void main(String[] args) {
        mySqrt(8);
    }
}
