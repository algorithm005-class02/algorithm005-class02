字符串匹配总结：
1、BF 算法中的 BF 是 Brute Force 的缩写，中文叫作暴力匹配算法，也叫朴素匹配算法；时间复杂度也比较高，是 O(n*m)，n、m 表示主串和模式串的长度。因为这种算法实现简单，对于处理小规模的字符串匹配很好用。
2、RK 算法是借助哈希算法对 BF 算法进行改造，即对每个子串分别求哈希值，然后拿子串的哈希值与模式串的哈希值比较，减少了比较的时间。所以，理想情况下，RK 算法的时间复杂度是 O(n)，跟 BF 算法相比，效率提高了很多。不过这样的效率取决于哈希算法的设计方法，如果存在冲突的情况下，时间复杂度可能会退化。极端情况下，哈希算法大量冲突，时间复杂度就退化为 O(n*m)。
3、KMP 算法是根据三位作者（D.E.Knuth，J.H.Morris 和 V.R.Pratt）的名字来命名的，算法的全称是 Knuth Morris Pratt 算法，简称为 KMP 算法。KMP 算法的核心思想假设主串是 a，模式串是 b。在模式串与主串匹配的过程中，当遇到不可匹配的字符的时候，我们希望找到一些规律，可以将模式串往后多滑动几位，跳过那些肯定不会匹配的情况。KMP 算法的时间复杂度是 O(n+m)。

BF代码示例：
public static int forceSearch(String txt, String pat) {
    int M = txt.length();
    int N = pat.length();

    for (int i = 0; i <= M - N; i++) {
        int j;
        for (j = 0; j < N; j++) {
            if (txt.charAt(i + j) != pat.charAt(j))
                break;
        }
        if (j == N) {
            return i;
        }
    }
    return -1;
}