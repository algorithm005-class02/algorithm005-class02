public class LeetCode_860_0341 {
}

class Solution860_1 {
    public boolean lemonadeChange(int[] bills) {
        int countOf5 = 0;
        int countOf10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                countOf5++;
            } else if (bills[i] == 10) {
                countOf5--;
                countOf10++;
            } else if (bills[i] == 20) {
                if (countOf10 > 0) {
                    countOf10--;
                    countOf5--;
                } else {
                    countOf5 -= 3;
                }
            }
            if (countOf5 < 0 || countOf10 < 0) {
                return false;
            }
        }
        return true;
    }
}

//精简代码
class Solution860_2 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) {
                five++;
            } else if (i == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}