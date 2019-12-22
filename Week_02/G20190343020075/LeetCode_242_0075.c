bool isAnagram(char * s, char * t){

    int hashmap[130] = {0};
    int len = 0;

    for (int cnt = 0; s[cnt]; ++cnt) {
        len++;
        hashmap[s[cnt]]++;
    }

    for (int cnt = 0; t[cnt]; ++cnt) {
        len--;
        hashmap[t[cnt]]--;

        if (hashmap[t[cnt]] < 0 || len < 0) {
            return false;
        }
    }

    if (len != 0 ) {
        return false;
    }
    else {
        return true;
    }

}


