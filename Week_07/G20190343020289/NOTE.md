学习笔记

# 布隆过滤器（Bloom Filter）
用于检索一个元素是否在一个集合中


- 优点是空间效率和查询时间都远远超过一般的算法，
- 缺点是有一定的误识别率和删除困难

# LRU Cache
HashTable+Double LinkedList

# 排序

## 分类
1. 比较类排序
2. 非比较类排序

## 初级排序-O(n^2)
1. 选择排序
```go
func selectionSort(arr []int) []int {
	length := len(arr)
	minIndex := 0
	for i := 0; i < length-1; i++ {
		minIndex = i
		for j := i + 1; j < length; j++ {
			if arr[j] < arr[minIndex] {
				minIndex = j
			}
		}
		arr[i], arr[minIndex] = arr[minIndex], arr[i]
	}
	return arr
}
```
2. 插入排序
```go
// 插入排序
func insertionSort(arr []int) []int {
	length := len(arr)
	preIndex := 0
	current := 0
	for i := 1; i < length; i++ {
		preIndex = i - 1
		current = arr[i]
		for preIndex >= 0 && arr[preIndex] > current {
			arr[preIndex+1] = arr[preIndex]
			preIndex--
		}
		arr[preIndex+1] = current
	}
	return arr
}
```
3. 冒泡排序
```go
func bubbleSort(arr []int) []int {
	length := len(arr)
	for i := 0; i < length-1; i++ {
		for j := 0; j < length-1-i; j++ {
			if arr[j] > arr[j+1] {
				arr[j], arr[j+1] = arr[j+1], arr[j]
			}
		}
	}
	return arr
}
```

## 高级排序-O(N*logN)
1. 快速排序
2. 归并排序
3. 堆排序

## 特殊排序-O(n)
1. 计算排序
2. 桶排序
3. 基数排序

