class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i : bills) {
            if (i == 5) {
                ++five;
            } else if (i == 10) {
                --five;
                ++ten;
                if (five < 0) {
                    return false;
                }
            } else if (i == 20) {
                if (ten > 0) {
                    --ten;
                    --five;
                    if (five < 0) {
                        return false;
                    }
                } else {
                    five -= 3;
                    if (five < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}