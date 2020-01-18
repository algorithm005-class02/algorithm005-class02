<!-- 二分查找基础代码模板(c)：
int left = 0, right = arraySize - 1, mid = -1; 
while (left <= right) {
    mid = left + ((right - left) >> 1); 
    if array[mid] == target: 
        break;// or return result 
    else if (array[mid] < target) 
        left = mid + 1; 
    else
        right = mid - 1; 
}

// 二分查找的递归实现模板
public int bsearch(int[] a, int n, int val) { 
    return bsearchInternally(a, 0, n - 1, val);
}
private int bsearchInternally(int[] a, int low, int high, int value) { 
    if (low > high) return -1; 
    int mid = low + ((high - low) >> 1); 
    if (a[mid] == value) { 
        return mid; 
    } 
    else if (a[mid] < value) { 
        return bsearchInternally(a, mid+1, high, value); 
    } 
    else { 
        return bsearchInternally(a, low, mid-1, value); 
    }
}

二分查找总结：
1、二分查找依赖的是顺序表结构，简单点说就是数组。
2、二分查找针对的是有序数据。
3、数据量太大也不适合二分查找。
4、二分查找除了用循环来实现，还可以用递归来实现。
5、O(logn) 时间复杂度。
6、根据具体问题，对模板进行调整即可。
7、个人感觉要注意left <= right的写法，是小于还时小于等于，要防止死循环的发生。
-->

<!--
 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
 其实找到最大或最小值，就是无序的地方
 只可能是一部分无序（前半部分或后半部分）
-->
int findMin(int* nums, int numsSize){
    int start = 0;
    int end = numsSize - 1;
    int index, mid;
    if(numsSize == 1) return nums[0];
    while (start < end) {
        mid = start + ((end - start) >> 1);
        if (nums[start] < nums[end]) {//全部有序
            index = start; 
            break;
        } else if (nums[mid] > nums[mid + 1]) {//mid为最大值索引，mid+1为最小值索引
            index = mid + 1;
            break;
        } else if (nums[mid - 1] > nums[mid]) {//mid-1为最大值索引，mid为最小值索引
            index = mid;
            break;
        } else if(nums[mid] > nums[end]) {//后半部分无序
            start =  mid + 1 ;
        } else {//前半部分无序
            end = mid;
        }
    }
    return nums[index];
}