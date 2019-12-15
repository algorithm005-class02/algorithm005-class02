func removeDuplicates(nums []int) int {
    l := len(nums)
    if (l < 2) {
        return l
    }
    
    index := 0
    for i := 1; i < l; i++ {
        if nums[index] != nums[i] {
            index++
            nums[index] = nums[i]
        }
    }
    return index + 1
}