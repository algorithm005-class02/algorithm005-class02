/*
 * @lc app=leetcode.cn id=242 lang=c
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (57.12%)
 * Likes:    138
 * Dislikes: 0
 * Total Accepted:    63.1K
 * Total Submissions: 110K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
/*
#include "stdio.h"
#include "stdbool.h"
#include "stdlib.h"
#include "string.h"
*/
/**
 * 1、暴力法，排序后比较两串
 * 
 * 
*/
void merge(char* s, int start, int middle, int end){
    int x = start;
    int y = middle +1;
    int i = 0;
    int k = 0;
    int try;
    char *temp = (char*)malloc((end-start+2)*sizeof(char));

    while(x <= middle && y <= end){
        if(s[x] >= s[y]){
            temp[i++] = s[x++];
        }else{
            temp[i++] = s[y++];
        }
    }
    while(x <= middle){
        temp[i++] = s[x++];
    }
    while(y <= end){
        temp[i++] = s[y++];
    }
    for(  k = 0 ; k < end-start+1 ; k ++){
        //TODO:There is a BUS ERROR while ACCESSING "s[k+start]" when I was debugged with gdb or lldb, but I cannot figure it out. pls help.
        s[k+start] = temp[k];
    }
    free(temp);
    temp = NULL;
}

void mymergesort(char* s, int start, int end){
    //terminator
    if(start == end) return;
    //process 
    int middle = start + ((end - start)>>1);

    //drill down
    mymergesort(s,start, middle);
    mymergesort(s,middle+1, end);
    //reverse
    merge(s,start, middle, end);
}

bool isAnagram(char * s, char * t){
    int s_size = 0;
    int t_size = 0;
    int i,j;
    while(s[s_size] != NULL){
        s_size++;
    }
    while(t[t_size] != NULL){
        t_size++;
    }
    if(s_size != t_size) return false;
    if(s_size == 0 && t_size == 0) return true;
    mymergesort(s,0,s_size-1);
    mymergesort(t,0,t_size-1);
    return !strcmp(s,t);
}

// @lc code=end

