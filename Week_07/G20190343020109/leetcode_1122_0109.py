class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        ans,cnt = [],collections.Counter(arr1)
        for i in arr2:
            if cnt[i]: ans.extend([i]*cnt.pop(i))
        for i in range(1001):
            if cnt[i]: ans.extend([i]*cnt.pop(i))
        return ans


    def relativeSortArray1(self, arr1: List[int], arr2: List[int]) -> List[int]:
        return sorted(arr1,key=(arr2+sorted(arr1)).index)