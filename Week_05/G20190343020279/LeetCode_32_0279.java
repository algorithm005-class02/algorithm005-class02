class Solution {
    public int longestValidParentheses(String s) {
    boolean a = true;
    int max = 0;
    char[] c = s.toCharArray();
    int[] iss = new int[c.length];
    for(int i = 0;i < c.length - 1;i++) {
        if (c[i] == '(' && c[i + 1] == ')') {
            iss[i] = 2;
            max = 2;
        }
    }
    do {
        a = false;
        for (int i = 0; i < iss.length; i++) {
            if (iss[i] == 0) continue;
            if (iss[i] > 0 && i - 1 >= 0 && c[i - 1] == '(' && i + iss[i] < c.length && c[i + iss[i]] == ')') {
                iss[i - 1] = iss[i] + 2;
                iss[i] = 0;
                if (max < iss[i - 1]) {
                    max = iss[i - 1];
                }
                a = true;
            } else if (iss[i] > 0 && i + iss[i] < iss.length && iss[i + iss[i]] > 0) {
                int t1 = i + iss[i];
                int t2 = iss[t1];
                iss[i] = iss[i] + t2;
                iss[t1] = 0;
                if (max < iss[i]) {
                    max = iss[i];
                }
                a = true;
            }
        }
    } while (a);
    return max;
    }
}