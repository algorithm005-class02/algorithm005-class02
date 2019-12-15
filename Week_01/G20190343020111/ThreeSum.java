public class ThreeSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //int [] nums= {-1, 0, 1, 2, -1, -4};
        int [] nums= {-1, 0, 1, 2, -1,2,1, 4};
        System.out.println(new ThreeSum().threeSum4(nums));
    }
/**
	 * 11-23
	 * @param nums
	 * @return
	 * 先从小到大进行排序，再从两边取元素进行相加，如果相加大于0，则右边元素下标--
	 * 如果相加小于0，则左边元素下标++，如果相加等于0，则记录，同时-- 和 ++。
	 * 如果连续出现大于0和小于0的情况，直接跳出寻找。减少寻找次数。
	 * 如果排序后第一个元素大于0，直接中止寻找
	 * 相同元素的处理：
	 * 目标元素相同，直接跳过
	 * 左右移动的元素相同，找到等于0的情况时，直接移动跳过
	 */
	public List<List<Integer>> threeSum4(int[] nums) {
		List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        
        int skiprepat=nums[0];
        for (int t=0;t<len-1;t++) {
        	if(nums[t]>0)return ans;
        	if(t>0&&skiprepat==nums[t]) {
        		skiprepat=nums[t];
        		continue;
        	}
        	skiprepat=nums[t];
        	int l=t+1,r=len-1;
        	while(l<r) {
        		if(l==t) l++;
        		if(r==t) r--;
        		int sum = nums[t]+nums[l]+nums[r];
        		if(sum>0)r--;
        		else if(sum<0)l++;
        		else if(sum==0) {
        			ans.add(Arrays.asList(nums[t],nums[l],nums[r]));
        			while(l<r && nums[l]==nums[l+1])l++;
        			while(l<r && nums[r]==nums[r-1])r--;
        			l++;
        			r--;
        			
        		}
        	}
        }
		return ans;
    }
    }