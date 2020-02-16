package algorithm.leetcode.字符串;

public class L5_palindrome {
    public String longestPalindrome(String s) {
    	String res = "";
    	
    	int n = s.length();
    	boolean dp[][] = new boolean[n][n];
    	//i 回文的起点，从后往前
    	//j 回文的终点，从i往前
    	for(int i=n-1;i>=0;i--) {
    		for(int j=i;j<n;j++) {
    			System.out.println(i+" "+j);
    			if(s.charAt(i)==s.charAt(j))
    			{
    				//(j-i<2) j==i 或 j-i==1 
    				// ...i,i+1.....j-1,j......
    				// 如果i+1.....j-1是回文，并且i=j那么 i.....j是回文
    				if ((j-i<2)||dp[i+1][j-1])
    					dp[i][j]=true;
    					
    			}
    			//dp[i][j]=s.charAt(i)==s.charAt(j)&&(j-i<2||dp[i+1][j-1]);
    			if(dp[i][j] && j-i+1>res.length()) {
    				res = s.substring(i,j+1);
    			}
    		}
    	}
    	
    	return res;
        
    }
    
    public static void main(String args[]) {
    	String s = "azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc";
    	String ss = "babad";
    	L5_palindrome p = new L5_palindrome();
    	String ret = p.longestPalindrome(ss);
    	System.out.println(ret);
    
    }
}
