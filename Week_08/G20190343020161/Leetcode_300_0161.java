public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (temp[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            temp[i] = x;
            if(i == size) ++size;
        }
        return size;
    }
}
