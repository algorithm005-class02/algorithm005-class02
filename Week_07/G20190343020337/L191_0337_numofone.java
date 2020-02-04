package algorithm.leetcode.位运算;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L191_numofone {
	
    // you need to treat n as an unsigned value
	
	/**
	 * 方法1：判断每一位是否是1
	 * 方法2：x&1 x>>1
	 * 方法4 清零最后一位的1 x&(x-1)
	 * @param n
	 * @return
	 */
    public int hammingWeight(int n) {
    	int sum = 0;
    	for(int i=0;i<32;i++)
    	{
    		//获取从右边起第i位的值
    		int z = (n>>i)&1;
    		sum = sum+z;
    	}
        return sum;
    }
    
    public static int hammingWeight_4(int n) {
    	int sum = 0;
    	while(n!=0) {
    		n = n&(n-1);//每次敲掉最右边的1
    		sum+=1;
    	}
    	return sum;
    }
    
    public static void main(String args[]) {
    	
		int number = 100000;
		
		int[] nums = new int[32];
		System.out.println();
		for(int i=0; i<Integer.SIZE-1; i++) {
			nums[Integer.SIZE-1-i] =  (number>>i)&1;
			
		}
		for(Integer i:nums) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println(Integer.toBinaryString(100000));
    }

}
