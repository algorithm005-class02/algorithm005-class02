package algorithm.leetcode.字符串;

public class L151_reversestr {
	
    public String reverseWords(String s) {
    	
        s = s.trim();
        if(s.equals("")){
            return s;
        }
    	
    	String[] splitted = s.split(" ");

    	StringBuffer sb = new StringBuffer();
    	for(int i=0,j=splitted.length-1;i<=j;i++,j--) {
    		String temp = splitted[i];splitted[i]=splitted[j];splitted[j]=temp;

    	}
    	for(String str:splitted)
    	{
    		if(!str.equals("")) {
    			sb.append(str);
    			sb.append(" ");
    		}
    	}
    	String ret = sb.substring(0, sb.length()-1);
    	return ret;
        
    }
    
    public static void main(String args[]) {
    	
    	String s =  "a good   example";
    	
    	String[] splitted = s.split(" ");

    	StringBuffer sb = new StringBuffer();
    	for(int i=0,j=splitted.length-1;i<=j;i++,j--) {
    		String temp = splitted[i];splitted[i]=splitted[j];splitted[j]=temp;

    	}
    	for(String str:splitted)
    	{
    		if(!str.equals("")) {
    			sb.append(str);
    			sb.append(" ");
    		}
    	}
    	String ret = sb.substring(0, sb.length()-1);
    	
    	
    	System.out.println(splitted);
    	
    }
    
    

}
