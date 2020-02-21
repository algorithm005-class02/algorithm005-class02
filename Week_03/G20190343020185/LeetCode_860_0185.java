class Solution {
    public boolean lemonadeChange(int[] bills) {
        //m:5的个数 n:10的个数
        int m = 0, n = 0;
        for (int i = 0; i < bills.length; i++){
            switch (bills[i]){
                case 20:
                {
                    if (n > 0){
                        n--;
                        m--;
                    }
                    else m = m - 3;
                    break;
                }
                case 10:
                {
                    m--;
                    n++;
                    break;
                }
                case 5:
                {
                    m++;
                    break;
                }
                default:break;
            }
            if(m < 0 || n < 0) return false;
        }
        return true;
    }
}
