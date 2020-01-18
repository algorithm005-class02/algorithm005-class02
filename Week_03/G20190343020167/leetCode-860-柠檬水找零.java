class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int b : bills) {
            if (b == 5) {
                count5++;
            } else if (b == 10) {
                if (count5 == 0) {
                    return false;
                } else {
                    count5--;
                    count10++;
                }
            } else {
                if (count10 > 0 && count5 > 0) {
                    count5--;
                    count10--;
                    continue;
                } else if (count5 >= 3) {
                    count5 -= 3;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}