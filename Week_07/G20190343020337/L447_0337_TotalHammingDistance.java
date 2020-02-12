package algorithm.leetcode.位运算;

public class L_TotalHammingDistance {
	/**
	 * 将所有数字转换成二进制表示
	 * 考察每一位，计算1的个数和0的个数
	 * 这一位的汉明距离是#1*#0
	 * @param nums
	 * @return
	 */
	public int totalHammingDistance(int[] nums) {
		
		
		int len = nums.length;
		
		int bitOfOne[] = new int[32];
		for(int n:nums) {
			for(int i=0; i<Integer.SIZE-1; i++) {
				bitOfOne[Integer.SIZE-1-i] =  ((n>>i)&1)+bitOfOne[Integer.SIZE-1-i];
			}
		}
		int ret = 0;
		for(int numberOfOne:bitOfOne) {
			int numberOfZero = (len-numberOfOne);
			ret+=numberOfOne*numberOfZero;
		}
		
		
		return ret;
		
	}
	
	/**
	 * 这个方法会超
	 * @param nums
	 * @return
	 */
    public int totalHammingDistance1(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                total+=hammingDistance(nums[i],nums[j]);
            }
        }
        return total;
        
    }

    public int hammingDistance(int x, int y) {

        int z = x^y;
        int ret = 0;
        while(z!=0){
            z = z&(z-1);
            ret++;

        }
        return ret;
    }
}
