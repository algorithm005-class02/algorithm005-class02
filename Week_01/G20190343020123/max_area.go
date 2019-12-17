package _123_Week_01

import (
    "fmt"
)

func maxArea(height []int) int{
    var l,r = 0,len(height) -1
    var area  = 0
    for l < r {
         area = maxAreas(area,minHeight(height[l],height[r])*(r - l))
        if(height[l] < height[r]){
            l++
        }else{
            r--
        }
    }
    return area
}
func minHeight(height1,height2 int) int {
    if(height1 < height2){
        return height1
    }
    return height2
}

func maxAreas(area1,area2 int) int {
    if (area1 > area2){
        return area1
    }
    return area2
}
func main(){
    var a = []int{1,8,6,2,5,4,8,3,7}
    fmt.Printf("the max area: %d\n",maxArea(a))
}