#include <iostream>
using namespace std;
class MyCircularDeque {
public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        capacity = k;
        size = 0;
        head = NULL;
        end = NULL;
        pre_end = NULL;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (size >= capacity) return false;
        LinkNode* add_node = new LinkNode;
        add_node->value = value;
        add_node->next = head;
        head = add_node;
        if (!end) end = add_node;
        if (size == 1)
        {
            pre_end = add_node;
        }
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (size >= capacity) return false;
        LinkNode* add_node = new LinkNode;
        add_node->value = value;
        add_node->next = NULL;
        if (end)
        {
            end->next = add_node;
        }
        if (size > 0)
        {
          pre_end = end;
        }
       if (!head) head = add_node;
       end = add_node;
       size++;
       return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (size == 0) return false;
        if (size == 1)
        {
            delete head;
            head = end = pre_end = NULL;
            size--;
            
        }
        else
        {
           if (size == 2) pre_end = NULL;
           LinkNode* tmp = head->next;
           delete head;
           head = tmp;
           size--;
        }
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (size == 0) return false;
        if (size == 1)
        {
            delete head;
            head = end = pre_end = NULL;
            size--;
        }
        else
        {
            delete end;
            end = pre_end;
            if (size == 2) pre_end = NULL;
            size--;
        }
        return true;
        
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (!head) return -1;
        return head->value;
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (!end) return -1;
        return end->value;
        
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return head;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return capacity >= size;
    }

    struct LinkNode
    {
        int value;
        LinkNode *next;
    };
    LinkNode *head;
    LinkNode *end;
    LinkNode *pre_end;
    int capacity;
    int size;


};

int main()
{
    MyCircularDeque deq(3);
    deq.getFront();
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */