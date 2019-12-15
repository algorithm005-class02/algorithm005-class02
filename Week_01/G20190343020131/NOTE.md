学习笔记
    数组array和链表linklist对比：
            lookup    append  delete  prepend  insert
    array      1        1       n        n       n
    linklist   n        1       1        1       1
    跳表：redis
    解决问题：linklist查找慢，从头开始遍历查找，可以跳着查找 时间复杂度 logn
    思想：降维(1维变成2维) 空间换时间 

