package _123_Week_01
// 旋转数组 https://leetcode-cn.com/problems/rotate-array/
import "fmt"

func rotate(nums []int, k int) {
    var tmp, previos = 0, 0
    for i := 0; i < k; i++ {
        previos = nums[len(nums)-1]
        for j := 0; j < len(nums); j++ {
            tmp = nums[j]
            nums[j] = previos
            previos = tmp
        }
    }
}

func main(){
    nums := []int{1,2,3,4,5,6,7}
    rotate(nums,2)
    fmt.Printf("array %d",nums)
}
