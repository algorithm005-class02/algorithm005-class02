public class MoveZeroes {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums= {6,7,8,0,1,0,3,4,5,0,12};
		new MoveZeroes().moveZeroes5(nums);
		for (int x : nums) {
			
			System.out.print(x+",");
		}
	}
//1、暴力求解，找到0，移动一次数据
	//2、只比较两位，有两个下标
	 public void moveZeroes5(int[] nums) {
		 int j=0;
		 for (int i=1;i<nums.length;i++) {
			 if (nums[i]!=0 && nums[j]==0) {
				 nums[j]=nums[i];
				 nums[i]=0;
				
			 }else if(nums[i]==0 && nums[j]==0) {
				 continue;
			 }
			 j++;
		 }
	 }
	 }