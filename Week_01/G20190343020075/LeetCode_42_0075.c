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

//    DataNode* dNode = NULL;
//
//    for (int cnt = 0; cnt < k; ++cnt) {
//        dNode = (DataNode*)malloc(sizeof(DataNode));
//        dNode->value = 0;
//        dNode->next = NULL;
//        dNode->pre = NULL;
//
//        if(deq->head == NULL) {
//            deq->head = dNode;
//        }
//        else{
//            deq->tail->next = dNode;
//            dNode->pre = deq->tail;
//        }
//        deq->tail = dNode;
//    }

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

int min( int a, int b ){
    return a>b?b:a;
}

int trap(int* height, int heightSize){

    int retSum = 0;
    MyCircularDeque* deq = myCircularDequeCreate(1000);

    for (int current=0; current < heightSize; ++current) {
        while ( !myCircularDequeIsEmpty(deq) && height[current] > height[myCircularDequeGetFront(deq)] ) {
            int top = myCircularDequeGetFront(deq);
            myCircularDequeDeleteFront(deq);
            if (myCircularDequeIsEmpty(deq)) {
                break;
            }
            int distance = current - myCircularDequeGetFront(deq) - 1;
            int bounded_height = min(height[current], height[myCircularDequeGetFront(deq)]) - height[top];
            retSum += distance * bounded_height;
        }

        myCircularDequeInsertFront(deq,current);

    }

    myCircularDequeFree(deq);

    return retSum;

}


