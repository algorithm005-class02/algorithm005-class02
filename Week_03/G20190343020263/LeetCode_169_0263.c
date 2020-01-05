int majorityElement(int* nums, int numsSize){
   int c = nums[0];
   int cnt = 1;

   for (int i = 1; i < numsSize; i++)
   {
     if (cnt == 0) {
       c = nums[i];
       cnt = 1;
     } else if (nums[i] != c) {
       cnt--;
     } else {
       cnt++;
     }
   } 
   return c;  
}
