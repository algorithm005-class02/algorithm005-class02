//调库函数
/*
class Solution {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
}
*/
//不调库函数
class Solution {
    public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for(int i = 0; i < a.length; ++ i)
            if('A' <= a[i] && a[i] <= 'Z' )
                a[i] =(char)(a[i] - 'A' + 'a');
        return new String(a);  
    }
}
