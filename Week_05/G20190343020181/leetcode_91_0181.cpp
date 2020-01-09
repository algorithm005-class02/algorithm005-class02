class Solution {
public:
    int numDecodings(string s) {
       if (s.empty()) return 0;
       if (s.size() == 1)
       return s[0] == '0' ? 0 : 1;
       int a = 1;
       int b = 0;
       b = s.back() == '0' ? 0 : 1;
       for (int i = s.size() - 2; i >= 0; i--)
       {
           if (s[i] == '0')
           {
               int tmp = b;
               b = 0;
               a = tmp;
               continue;
           }
           if ((s[i] - '0') * 10 + (s[i + 1] - '0') <= 26)
           {
               int tmp = b;
               b = b + a;
               a = tmp;
           }
           else
           {
               a = b;
           }
       }
    return b;
    }
};