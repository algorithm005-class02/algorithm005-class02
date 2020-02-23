//
//  PerfectSquares.m
//  Algorithm
//
//  Created by liuk on 2020/2/23.
//  Copyright © 2020 glodon. All rights reserved.
//

#import "PerfectSquares.h"

@implementation PerfectSquares

/* BFS */

typedef struct {
    int length, max;
    int front, rear;
    int *sq;
} queue;

queue* queueCreate(int k) {
    queue* a;
    if (k < 0)
        return NULL;
    else
        a = (queue*) malloc(sizeof(queue));
    if (!a)
        return NULL;
    else
    {
        a->max = k+1;
        a->length = a->front = a->rear = 0;
        a->sq = (int *)malloc(sizeof(int) * (k+1));
        if (!a->sq)
        {
            free(a);
            return NULL;
        }
        return a;
    }
}

int enQueue(queue* obj, int value) {
    if (obj->length == (obj->max - 1))
        return 0;
    else
    {
        obj->sq[obj->rear] = value;
        obj->rear = (obj->rear + 1) % obj->max;
        obj->length++;
    }
        
    return 1;
}

int deQueue(queue* obj) {
    int head;
    
    if (obj->front == obj->rear)
        return 0;
    else
    {
        head= obj->front;
        obj->front = (obj->front + 1) % obj->max;
        obj->length--;
        return obj->sq[head];
    }
}

int queueLength(queue *obj)
{
    return obj->length;
}


int isEmpty(queue* obj) {
     if (obj->front == obj->rear)
        return 1;
    else
        return 0;
}

int isFull(queue* obj) {
    if (obj->length == obj->max - 1)
        return 1;
    else
        return 0;
}

void queueFree(queue* obj) {
    free(obj->sq);
    free(obj);
    return;
}


int numSquares(int n){
    int i,j,next, curr, size, steps = 0, *visited;
    queue *q;
    
    if (n == 0 || n == 1)
        return n;
    
    q = queueCreate(n + 1);
    visited = (int *)malloc(sizeof(int) * (n+1));
    for (i = 0; i <= n; i++)
        visited[i] = 0;
    
    //根节点入队列
    enQueue(q, 0);
    visited[0] = 1;
    
    while(!isEmpty(q))
    {
        //深度加一
        steps++;
        size = queueLength(q);
        for (i = 0; i < size; i++)
        {
            //遍历子节点
            curr = deQueue(q);
            for (j = 1; j * j <= n; j++)
            {
                next = curr + j*j;
                if (next == n) return steps;
                if (next > n) break;
                if (visited[next]) continue;
                //加入队列，以待访问其子节点
                visited[next] = 1;
                enQueue(q, next);
            }
        }
    }
    queueFree(q);
    free(visited);
    return steps;
}
@end
