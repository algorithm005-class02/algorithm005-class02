package algorithm.leetcode.位运算;

public class L_Queen {
	
	int count = 0;
	
	public int totalNQueens(int n) {
		if(n<1) {
			return count;
		}
		dfs(0,n,0,0,0);
		return count;
	}
	
	public void dfs(int level,int max,int cols,int pie,int na) {
		if(level>=max) {
			count++;
			System.out.println(cols);
			return;
		}
		//获取所有空余的位置
		//(cols|pie|na)是所有的已经占用的位置
		//~(cols|pie|na) 是所有未占用的位置，但是包括了高位原来的0。
		//((1<<max)-1)包含了max位所有的1 例如8个1 11111111
		int bits = ~ (cols|pie|na) & ((1<<max)-1);
		while(bits!=0) {
			//#得到最低位的1
			//bit&-bit  
			//将最后一个1置为0
			//bits = bits&(bits-1);
			int p = bits&(-bits);
			bits = bits&(bits-1);
			dfs(level+1,max,(cols|p),(pie|p)<<1,(na|p)>>1 );
			//不需要revert
		}
	}

}
