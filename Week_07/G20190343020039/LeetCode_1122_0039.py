class Solution:
  def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
    count = [0 for _ in range(1001)]
    for n in arr1:
      count[n] += 1
    idx = 0
    for n in arr2:
      while count[n] > 0:
        arr1[idx] = n
        idx += 1
        count[n] -= 1
    for n, _ in enumerate(count):
      while count[n] > 0:
        arr1[idx] = n
        idx += 1
        count[n] -= 1
    return arr1

