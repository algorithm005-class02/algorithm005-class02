package smart33690;

import java.util.ArrayList;
import java.util.List;

/**
 * n的幂次方
 */
public class LeetCode050 {
    public static void main(String[] args) {
        LeetCode050 leetCode050 = new LeetCode050();
        Double res = leetCode050.myPow(2.00000,90);

        System.out.println(res);
    }
    public double myPow(double x, int n) {
        if(n<0){
            return 1.0/myPow(x,-n);
        }
        if (n==0){
            return 1.0;
        }
        double res ;
        if( n%2 == 0){
            return  myPow(x,n/2) * myPow(x,n/2);
        } else {
            return myPow(x,n/2) * myPow(x,n/2)*x;
        }
    }

}
