package algorithm.leetcode.排序;

public class L493_reversepair {

	 public int reversePairs(int[] array) {
		 
		 return mergeSort(array,0,array.length-1);
		 
	 }
	
    //先排序左右子数组，然后合并两个有序子数组
    public int mergeSort(int[] array,int left,int right){
        if(right<=left) return 0;
        int mid = (left+right)>>1;
        int count =mergeSort(array,left,mid)+
        mergeSort(array,mid+1,right);
        int j=mid+1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long)array[i] > 2*(long)array[j])
                j++;
            count += j - (mid + 1);
        }
 
        merge(array,left,mid,right);
        return count;
    }

    private void merge(int[] array, int left, int mid, int right) {

        int[] temp = new int[right-left+1];
        int i=left,j=mid+1,k=0;
        while( i<=mid && j<=right ){
            temp[k++]= array[i]<=array[j]?array[i++]:array[j++];
        }
        while (i<=mid) temp[k++]=array[i++];
        while (j<=right) temp[k++]=array[j++];

        for(int p=0;p<temp.length;p++){
            array[left+p]=temp[p];
        }

    }
    
    public static void main(String args[]) {
    	
     }
	
	
	/**
	 * 这个会超时
	 * @param nums
	 * @return
	 */
    public int reversePairs_brutal(int[] nums) {
        int ret = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
            	
            	int z = nums[i]>>1;
            	if(z>nums[j]) {
            		ret++;
            	}else if(z==nums[j] && ((nums[i] & 1) == 1) ) {
            		ret++;
            	}
            	

            }
        }
        return ret;
        
    }

}
