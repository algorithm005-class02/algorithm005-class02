package G20190343020187;

public class LeetCode_433_0187 {
    public int minMutation(String start, String end, String[] bank) {
        int res = backtrack(start, end, bank, new boolean[bank.length]);
        if (res > bank.length) {
            return -1;
        }
        return res;
    }

    private int backtrack(String current, String end, String[] bank, boolean[] used) {
        if (current.equals(end)) {
            return 0;
        }
        int min = bank.length + 1;
        for (int i = 0; i < bank.length; i++) {
            if (!used[i] && match(current, bank[i])) {
                used[i] = true;
                min = Math.min(1 + backtrack(bank[i], end, bank, used), min);
                used[i] = false;
            }
        }
        return min;
    }

    private boolean match(String a, String b) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_433_0187().minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}
