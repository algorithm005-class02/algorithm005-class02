void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    int x = m-1;
    int y = n-1;
    if(n<0 || m<0)
        return;

    for(int i = m+n-1; i >= 0; i--){
        if(x<0){
            nums1[i] = nums2[y--];
        }else if(y<0){
            nums1[i] = nums1[x--];
        }else if(nums1[x] >= nums2[y]){
            nums1[i] = nums1[x--];
        }else{
            nums1[i] = nums2[y--];
        }
 //       printf("%d:%d(x=%d,y=%d)\n",i,nums1[i],x+1,y+1);
    }
}