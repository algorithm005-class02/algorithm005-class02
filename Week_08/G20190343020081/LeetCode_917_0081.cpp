class Solution {
public:
    string reverseOnlyLetters(string S) {
        int left = 0;
        int right = S.size() - 1;
        while (left < right ) {
            while ( !isalpha(S[left]) && left < right ) left ++;
            while ( !isalpha(S[right]) && left < right ) right --;
            swap(S[left++], S[right--]);
        }
        return S;
    }
};
