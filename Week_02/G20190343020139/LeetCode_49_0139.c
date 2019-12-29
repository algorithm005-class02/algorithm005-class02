struct mapping{
    char* str;
    int size;
    int count[26];
};

struct hash_table{
    int count[26];
    int numbers;
    char** str;
    int size;
};

int do_hash(struct mapping str, struct hash_table * hash, int *hash_size){
    int bingo = 0;
    int num = 0;
    for(int i = 0; i < *hash_size; i++){
        for(int j=0; j<26; j++){
            bingo = 1;
            if(hash[i].count[j] != str.count[j]){
                bingo = 0;
                break;
            }

        }
        if(bingo){
            hash[i].numbers ++;
            hash[i].str = realloc(hash[i].str, hash[i].numbers*(sizeof(char*)));
            for(int k = 0; k < hash[i].numbers; k++){
                
                if(k==(hash[i].numbers - 1)){
                    
                    hash[i].str[k] = (char*)malloc(str.size+1);
                    strcpy(hash[i].str[k],str.str);
                }
            }
            return i;
        }
            
    }
    for(int i=0; i<26; i++){
        hash[*hash_size].count[i] = str.count[i];

    }

    hash[*hash_size].numbers = 1;
    hash[*hash_size].size = str.size;
    hash[*hash_size].str = (char**) malloc(sizeof(char*));
    hash[*hash_size].str[0] = (char*) malloc(sizeof(char)*(str.size+1));
    strcpy(hash[*hash_size].str[0],str.str); 
    (*hash_size) ++;
    return (*hash_size)-1;
    
}


int getsize(char* str){
    int res = 0;
    while(str[res]!='\0'){
        res++;
    }
    return res;
}

char *** groupAnagrams(char ** strs, int strsSize, int* returnSize, int** returnColumnSizes){

    char *** ans;
    int size;
    int row = 0;
    int *hash_size = (int*)malloc(sizeof(int));
    (*hash_size) = 0;
    int *col_size = (int*)malloc(sizeof(int) * strsSize);
    struct mapping* map = (struct mapping*) malloc (sizeof(struct mapping)*strsSize);
    struct hash_table* hash = (struct hash_table*) malloc (sizeof(struct hash_table)*strsSize);

    for(int i = 0; i<strsSize; i++){
        size = getsize(strs[i]);
      memset(map[i].count,0,sizeof(map[i].count));
        map[i].str = (char*) malloc(size+1);
        for(int j = 0; j < size; j++){
            map[i].count[strs[i][j] - 'a'] ++;
        }
        strcpy(map[i].str, strs[i]);
        map[i].size = size;
        do_hash(map[i],hash,hash_size);

    }
    ans = (char***)malloc(sizeof(char**)*(strsSize));
    for(int i = 0; i<*hash_size; i++){
        ans[i] = (char**)malloc(sizeof(char*)*strsSize);
        for(int j = 0; j<hash[i].numbers; j++){
            ans[i][j] = (char*)malloc(sizeof(char)*(hash[i].size+1));
            strcpy(ans[i][j], hash[i].str[j]);          
        }
        row++;
        col_size[i] = hash[i].numbers;
    }

    free(map);
    free(hash);
    map = NULL;
    hash = NULL;

    *returnSize = row;
    *returnColumnSizes = col_size;
    return ans;
}