typedef struct DataNode {
    int value;
    struct DataNode* next;
    struct DataNode* pre;
} DataNode;

typedef struct {
    struct DataNode* head;
    struct DataNode* tail;
    int len;
    int maxLen
} MyCircularDeque;



/** Initialize your data structure here. Set the size of the deque to be k. */

MyCircularDeque* myCircularDequeCreate(int k) {
    MyCircularDeque* deq = (MyCircularDeque*)malloc(sizeof(MyCircularDeque));
    deq->maxLen = k;
    deq->len = 0;
    deq->head = NULL;
    deq->tail = NULL;

    return deq;
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertFront(MyCircularDeque* obj, int value) {
    if (obj->maxLen == obj->len) {
        return false;
    }
    DataNode* dNode = (DataNode*)malloc(sizeof(DataNode));
    dNode->value = value;
    dNode->next = NULL;
    dNode->pre = NULL;

    if(obj->head == NULL) {
        obj->head = dNode;
        obj->tail = dNode;
    }
    else{
        dNode->next = obj->head;
        obj->head->pre = dNode;
        obj->head = dNode;
    }
    (obj->len)++;

    return true;
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeInsertLast(MyCircularDeque* obj, int value) {
    if (obj->maxLen == obj->len) {
        return false;
    }
    DataNode* dNode = (DataNode*)malloc(sizeof(DataNode));
    dNode->value = value;
    dNode->next = NULL;
    dNode->pre = NULL;

    if(obj->head == NULL) {
        obj->head = dNode;
    }
    else{
        obj->tail->next = dNode;
        dNode->pre = obj->tail;
    }
    obj->tail = dNode;
    (obj->len)++;

    return true;
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteFront(MyCircularDeque* obj) {
    if (obj->len < 1) {
        return false;
    }

    DataNode* dNode = obj->head;

    if (obj->len == 1) {
        obj->head = NULL;
        obj->tail = NULL;
    }
    else{
        obj->head = obj->head->next;
        obj->head->pre = NULL;
    }

    free(dNode);
    (obj->len)--;
    return true;
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
bool myCircularDequeDeleteLast(MyCircularDeque* obj) {
    if (obj->len < 1) {
        return false;
    }

    DataNode* dNode = obj->tail;

    if (obj->len == 1) {
        obj->head = NULL;
        obj->tail = NULL;
    }
    else{
        obj->tail = obj->tail->pre;
        obj->tail->next = NULL;
    }

    free(dNode);
    (obj->len)--;
    return true;
}

/** Get the front item from the deque. */
int myCircularDequeGetFront(MyCircularDeque* obj) {
    if (obj->len == 0) {
        return -1;
    }
    return obj->head->value;
}

/** Get the last item from the deque. */
int myCircularDequeGetRear(MyCircularDeque* obj) {
    if (obj->len == 0) {
        return -1;
    }
    return obj->tail->value;
}

/** Checks whether the circular deque is empty or not. */
bool myCircularDequeIsEmpty(MyCircularDeque* obj) {
    return obj->len == 0;
}

/** Checks whether the circular deque is full or not. */
bool myCircularDequeIsFull(MyCircularDeque* obj) {
    return obj->len == obj->maxLen;
}

void myCircularDequeFree(MyCircularDeque* obj) {
    DataNode* dNode = NULL;
    while (obj->head != NULL) {
        dNode = obj->head;
        obj->head = obj->head->next;
        free(dNode);
    }
    free(obj);
}
