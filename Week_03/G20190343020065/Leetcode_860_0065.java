class Solution {
    /* 思路
     * 1.分别定义5美元与10美元个数变量five、ten
     * 2.如果顾客支付5美元，那么five + 1；
     * 3.如果顾客支付10美元，如果有5美元，那么five - 1，ten+ 1；如果没有5没有，那么返回false
     * 4.如果顾客支付20美元，有两种找零方法：5 + 10，5 + 5 + 5，优先使用前者找零，这样能保证手中5美元零钱最多，能够卖出去的数量最多。
          如果有5没有且有10美元，five - 1，ten - 1；
          如果没有则找零三个5美元，即five - 3；
          否则无法找零，返回false
    */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int tne = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                if (five >= 1) {
                    five--;
                    ten++
                }
                else return false;
            }
            else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}
