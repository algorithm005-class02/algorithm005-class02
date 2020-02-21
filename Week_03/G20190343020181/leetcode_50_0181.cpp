class Solution {
public:
    double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;

        double tmp_res = myPow(x, n / 2);
        if (n % 2 == 1 || n % 2 == -1)
        {
            if (n > 0)
            return tmp_res * tmp_res * x; 
            else
            return tmp_res * tmp_res / x; 
        }
        else
        {
            return tmp_res * tmp_res; 
        }
    }
};


int main()
{
   Solution c;
   c.myPow(34.00515, -3);

    return 0;
}