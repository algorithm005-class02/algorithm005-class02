class Solution:
  def reversePairs(self, nums: List[int]) -> int:
    return self.mergeSort(nums, 0, len(nums) - 1)

  def mergeSort(self, nums, start, end) -> int:
    if start >= end: return 0
    mid = start + (end - start) // 2
    count = self.mergeSort(nums, start, mid) + self.mergeSort(nums, mid+1, end)
    j = mid + 1
    for i in range(start, mid + 1):
      while j <= end and nums[i] > nums[j]*2:
        j += 1
      count += j - (mid + 1)
    nums[start:end+1] = sorted(nums[start:end+1])
    return count

