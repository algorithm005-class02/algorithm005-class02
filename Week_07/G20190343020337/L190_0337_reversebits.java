package algorithm.leetcode.位运算;


//获取x的第n位值(0或1)：(x>>n)&1
//仅将第n位置为1：x|(1<<n)
//仅将第n位置为0：x&(~(1<<n))
public class L190_reversebits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	
    	for(int i=1;i<=32;i++) {
    		//获取第i位的值
    		int sig = (n>>i)&1;
    		//如果第i位为1，那么将第i位设置为0
    		if(sig==1) {
    			n=n&(~(1<<i));
    		//如果第i位为0，那么将第i位设置为1
    		}else {
    			n = n|(1<<i);
    		}
    	}
    	
    	return n;
        
    }
}
