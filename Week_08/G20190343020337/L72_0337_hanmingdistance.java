package algorithm.leetcode.字符串;

public class L72_hanmingdistance {
	
    public int minDistance(String word1, String word2) {
    	
    	int m = word1.length();
    	int n = word2.length();
    	//都有一个空字符串
    	int d[][] = new int[m+1][n+1];
    	
    	for(int i=0;i<n+1;i++) {
    		d[0][i]=i;
    	}
    	for(int i=0;i<m+1;i++) {
    		d[i][0]=i;
    	}
    	
    	for(int i=1;i<=m;i++) {
    		for(int j=1;j<=n;j++) {
    			if(word1.charAt(i-1)==word2.charAt(j-1)) {
    				d[i][j]=d[i-1][j-1];
    			}else {
    				int min = (d[i-1][j-1]+1)<(d[i][j-1]+1)?(d[i-1][j-1]+1):(d[i][j-1]+1);
    				min = min<d[i-1][j]+1?min:d[i-1][j]+1;
    				d[i][j] = min;
    			}
    		}
    	}
    	return d[m][n];
    	
    	/**
    	 * d[i][j] 表示 word1 的前 i 个字母和 word2 的前 j 个字母之间的编辑距离
    	 * if word1[i]==word2[j]
    	 * 		 d[i][j]=d[i-1][j-1]
    	 * else
    	 *       d[i][j] = min(d[i-1][j-1]+1,d[i][j-1]+1,d[i-1][j]+1)
    	 * 
    	 * 
    	 */
    }
	
	
	public static void main(String args[]) {
		
		L72_hanmingdistance l = new L72_hanmingdistance();
		l.minDistance("abcd", " abc");
		
		
	}

}
