package _123_Week_01
//删除排序数组中的重复项项  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
import "fmt"

func removeDuplicates(nums []int) int {
    low := 0
    for fast := 0; fast < len(nums); fast++ {
        if (nums[low] != nums[fast]) {
            // fmt.Printf("low=%d,fast=%d,nums=%d\n",low,fast,nums)
            nums[low+1] = nums[fast]
            low++
        }
    }
    return low + 1
}

func main() {
    nums := []int{0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4}
    len := removeDuplicates(nums)
    fmt.Printf("%d", len)
}
