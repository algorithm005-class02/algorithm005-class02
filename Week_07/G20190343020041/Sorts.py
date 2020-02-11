from typing import List


def select_sort(nums: List[int]):
    for i in range(len(nums)):
        min_index = i
        for j in range(i + 1, len(nums)):
            if nums[j] <= nums[min_index]:
                min_index = j
        nums[i], nums[min_index] = nums[min_index], nums[i]
    return nums


print("select_sort: ", select_sort([5, 3, 1, 2, 0, 4]))


def insert_sort(nums: List[int]):
    for i in range(1, len(nums)):
        preIndex = i - 1
        current = nums[i]
        while preIndex >= 0 and current < nums[preIndex]:
            nums[preIndex + 1] = nums[preIndex]
            preIndex -= 1
        nums[preIndex + 1] = current
    return nums


print("insert_sort: ", insert_sort([5, 3, 1, 2, 0, 4]))


def bubble_sort(nums: List[int]):
    for i in range(len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if nums[j] < nums[i]:
                nums[j], nums[i] = nums[i], nums[j]
    return nums


print("bubble_sort: ", bubble_sort([5, 3, 1, 2, 0, 4]))


def partition(nums: List[int], begin: int, end: int):
    pivot, counter = end, begin
    for i in range(begin, end):
        if nums[i] < nums[pivot]:
            nums[i], nums[counter] = nums[counter], nums[i]
            counter += 1
    nums[pivot], nums[counter] = nums[counter], nums[pivot]
    return counter


def quick_sort(nums: List[int], begin: int = None, end: int = None):
    if begin is None or end is None:
        begin, end = 0, len(nums) - 1
    if end <= begin: return
    pivot = partition(nums, begin, end)
    quick_sort(nums, begin, pivot - 1)
    quick_sort(nums, pivot + 1, end)
    return nums


print("quick_sort: ", quick_sort([5, 3, 1, 2, 0, 4]))


def merge(nums, left, mid, right):
    temp = [0] * (right - left + 1)
    i, j, k = left, mid + 1, 0
    while i <= mid and j <= right:
        if nums[i] < nums[j]:
            temp[k] = nums[i]
            i += 1
        else:
            temp[k] = nums[j]
            j += 1
        k += 1
    while i <= mid:
        temp[k] = nums[i]
        i += 1
        k += 1
    while j <= right:
        temp[k] = nums[j]
        j += 1
        k += 1

    for q in range(right - left + 1):
        nums[q + left] = temp[q]


def merge_sort(nums: List[int], left: int = None, right: int = None):
    if left is None or right is None:
        left, right = 0, len(nums) - 1
    if right <= left:
        return
    mid = (left + right) >> 1
    merge_sort(nums, left, mid)
    merge_sort(nums, mid + 1, right)
    merge(nums, left, mid, right)

    return nums


print("merge_sort: ", merge_sort([5, 3, 1, 2, 0, 4]))


def heapify(arr, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2
    if l < n and arr[l] > arr[largest]:
        largest = l
    if r < n and arr[r] > arr[largest]:
        largest = r
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)


def heap_sort(nums: List[int]):
    n = len(nums)
    if n == 0: return
    # build largest heap
    for i in range(int(n / 2) - 1, -1, -1):
        heapify(nums, n, i)
    for i in range(n - 1, -1, -1):
        nums[0], nums[i] = nums[i], nums[0]
        heapify(nums, i, 0)
    return nums


print("heap_sort: ", heap_sort([5, 3, 1, 2, 0, 4]))
