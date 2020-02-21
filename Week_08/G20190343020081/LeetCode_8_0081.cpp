class Solution {
public:
    int myAtoi(string str) {
        int res = 0;
        int flag = 0;
        int i = 0;
        while (str[i] == ' ') { i ++; }
        if (str[i] == '-') { flag = 1; }
        if (str[i] == '-' || str[i] == '+') { i ++; }
        while(i < str.size() && isdigit(str[i])) {
            int bit = str[i] - '0';
            if (res > INT_MAX / 10 || (res == INT_MAX / 10 && bit > 7 ))
                return flag > 0 ? INT_MIN : INT_MAX; 
            res = res*10 + bit;
            i ++;
        }
        return flag > 0 ? -res : res; 
    }
};
