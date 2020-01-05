int search(int* nums, int numsSize, int target){
   int i, j, mid;

   i = 0; j = numsSize - 1;
   
   while (i < j)
   {
     mid = (i + j) / 2;

     if (nums[mid] >= nums[0] && (target > nums[mid] || target < nums[0])) {
       i = mid + 1;
     } else if (target < nums[0] && target > nums[mid])
       i = mid + 1;
     else {
       j = mid;
     }
   }
   return i == j && nums[i] == target ? i : -1;
}
