//Accepted
//29/29 cases passed (16 ms)
//Your runtime beats 89.59 % of c submissions
//Your memory usage beats 5.03 % of c submissions (8.1 MB)

#define LEN 100


typedef struct hash_node{
    int key;
    int val;
    struct hash_node *next;
} Node;

int get_index(int val){
    int index = val % LEN;
    if(index > 0) return index;
    return -index;
}


void hash_init(Node** hash_table){
    int i;
    for(i = 0; i < LEN; i++){
        hash_table[i] = (Node*)malloc(sizeof(struct hash_node));
        memset(hash_table[i],0,sizeof(struct hash_node));
    }
}

void hash_conflict_insert(Node* hash_node, Node* new_node){
    if(hash_node == NULL)
        hash_node = new_node;
    else{
        while(hash_node->next != NULL){
            hash_node = hash_node->next;
        }
        hash_node->next = new_node;
    }
}

void hash_insert(Node** hash_table, int val, int key){
    Node* node = (Node*) malloc (sizeof(Node));
    int index = get_index(val);
    node->key = key;
    node->val = val;
    node->next = NULL;

    hash_conflict_insert(hash_table[index],node);
}

int  hash_find(Node **hash_table, int val){
    int index = get_index(val);
    Node *hash;
    int temp,temp1;
    if(hash_table[index] == NULL)
        return -1;
    hash = hash_table[index]->next;
    while(hash!=NULL){
        temp = hash->val;
        temp1 = hash->key;
        if(hash->val == val){
            return hash->key;
        }
        hash = hash->next;
    }
    return -1;
}

int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    int *ret = (int*)malloc(sizeof(int)*2);
    int result = -1;
    *returnSize = 2;
    Node **hash_table = (Node**)malloc(sizeof(Node *)*LEN);
    hash_init(hash_table);
    for(int i = 0 ; i < numsSize ; i++){
        hash_insert(hash_table, nums[i],i);
        result = hash_find(hash_table,target-nums[i]);
        if(result >= 0 & result != i){
            ret[0] = result;
            ret[1] = i;
            return ret;
        }
    }
    return ret;
}
