package week07

import (
	"fmt"
	"math"
	"testing"
)

// 1、冒泡排序（Bubble Sort）
func bubbleSort(nums []int) []int {

	lastExchangeIndex := 0      // 记录最后一次交换的位置
	sortBorder := len(nums) - 1 // 记录有序边界
	for i := 0; i < len(nums); i++ {

		isComplete := true
		for j := 0; j < sortBorder; j++ {

			if nums[j] > nums[j+1] {
				tmp := nums[j]
				nums[j] = nums[j+1]
				nums[j+1] = tmp

				isComplete = false
				lastExchangeIndex = j
			}
		}

		sortBorder = lastExchangeIndex
		if isComplete { // 循环一次如果没有需要交换的，证明已经有序了
			break
		}
	}
	return nums
}

// 2、选择排序（Selection Sort）

func selectionSort(nums []int) []int {

	minIndex := 0
	for i := 0; i < len(nums)-1; i++ {

		minIndex = i
		for j := i + 1; j < len(nums)-1; j++ {
			if nums[j] < nums[minIndex] {
				minIndex = j
			}
		}
		tmp := nums[i]
		nums[i] = nums[minIndex]
		nums[minIndex] = tmp
	}
	return nums
}

// 3、插入排序（Insertion Sort）

func insertionSort(nums []int) []int {

	var current int
	preIndex := 0
	for i := 1; i < len(nums); i++ {

		preIndex = i - 1
		current = nums[i]
		for preIndex >= 0 && nums[preIndex] > current {
			nums[preIndex+1] = nums[preIndex]
			preIndex--
		}
		nums[preIndex+1] = current
	}
	return nums
}

// 4、希尔排序（Shell Sort）

func shellSort(nums []int) []int {

	return nums
}

// 5、归并排序（Merge Sort）
func mergeSort(nums []int) []int {
	l := len(nums)
	if l < 2 {
		return nums
	}
	middle := int(math.Floor(float64(l / 2)))
	left := nums[0:middle]
	right := nums[middle:len(nums)]

	return merge(mergeSort(left), mergeSort(right))
}
func merge(left, right []int) []int {
	result := make([]int, len(left)+len(right))
	i, j, k := 0, 0, 0
	for i < len(left) && j < len(right) {

		if left[i] < right[j] {
			result[k] = left[i]
			i++
		} else {
			result[k] = right[j]
			j++
		}
		k++
	}

	for i < len(left) {
		result[k] = left[i]
		i++
		k++
	}

	for j < len(right) {
		result[k] = right[j]
		j++
		k++
	}

	return result
}

//6 快速排序（Quick Sort）
// 单边循环(递归)
func quickSort(arr []int, startIndex, endIndex int) {
	if startIndex >= endIndex {
		return
	}

	pivotIndex := partition(arr, startIndex, endIndex)
	quickSort(arr, startIndex, pivotIndex-1)
	quickSort(arr, pivotIndex+1, endIndex)
}

//分区
func partition(arr []int, startIndex, endIndex int) int {

	pivot := arr[startIndex]
	mark := startIndex

	for i := startIndex + 1; i <= endIndex; i++ {

		if arr[i] < pivot {
			mark++
			tmp := arr[mark]
			arr[mark] = arr[i]
			arr[i] = tmp
		}
	}

	// 当指针和基准元素重合的时候
	arr[startIndex] = arr[mark]
	arr[mark] = pivot

	return mark
}

// 双边循环
func quickSortLeftRight(arr []int, startIndex, endIndex int) {

	if startIndex >= endIndex {
		return
	}

	pivotIndex := partitionLeftRight(arr, startIndex, endIndex)
	quickSortLeftRight(arr, startIndex, pivotIndex-1)
	quickSortLeftRight(arr, pivotIndex+1, endIndex)
}

// 分区
func partitionLeftRight(arr []int, startIndex, endIndex int) int {
	pivot := arr[startIndex]
	left := startIndex
	right := endIndex

	for left < right {

		for left < right && arr[right] > pivot {
			right--
		}

		for left < right && arr[left] < pivot {
			left++
		}

		if left < right {
			tmp := arr[left]
			arr[left] = arr[right]
			arr[right] = tmp
		}
	}

	// pivot元素 和 left指针重合
	arr[startIndex] = arr[left]
	arr[left] = pivot
	return left
}

func TestSort(t *testing.T) {

	fmt.Println(mergeSort([]int{1, 7, 8, 9, 2, 3, 4, 6, 6, 8, 5, 9, 1}))
}
