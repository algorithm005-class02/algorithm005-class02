func rotate(nums []int, k int)  {
        k = k%len(nums)//注意k值超出数组长度的时候，取余
        nums1 := nums[0:len(nums)-k]
        nums2 := nums[len(nums)-k:len(nums)]
        reverse(nums1)
        reverse(nums2)
        reverse(nums)
}

func reverse (nums []int){
    for i:=0; i< len(nums)/2;i++{
        nums[i],nums[len(nums)-i-1] = nums[len(nums)-i-1],nums[i]
    }
}