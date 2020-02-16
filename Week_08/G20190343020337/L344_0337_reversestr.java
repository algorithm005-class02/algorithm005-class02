package algorithm.leetcode.字符串;

public class L344_reversestr {
	
    public void reverseString(char[] s) {
    	
    	int slen = s.length;
    	if(slen<=1) {
    		return;
    	}
    	int start = 0;
    	int end  = slen-1;
    	while(start<end) {
    		char temp = s[start];
    		s[start]=s[end];
    		s[end]=temp;
    		start++;
    		end--;
    	}
        
    }
    
    public void reverseString_(char[] s) {
    	
    	int slen = s.length;
    	if(slen<=1) {
    		return;
    	}
    	for(int i=0,j=slen-1;i<j;i++,j--) {
    		char temp = s[i];s[i]=s[j];s[j]=temp;
    	}
        
    }

}
