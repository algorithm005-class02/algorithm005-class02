int firstUniqChar(char * s){
    if(s == NULL) return -1;
    int len = strlen(s);
    if(len == 1) return 0;
    int arr[26] = {0};
    for(int i = 0; i < len; i++) {
        arr[s[i] - 'a']++;
    }
    for(int i = 0; i < len; i++) {
        if(arr[s[i] - 'a'] == 1) {
            return i;
        }
    }
    return -1;
}