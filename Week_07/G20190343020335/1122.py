class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        s = collections.Counter(arr1)
        result = []
        for a2 in arr2:
            temp = s[a2]
            result += [a2 for _ in range(temp)]
        temp = []
        for a1 in arr1:
            if a1 not in arr2:
                temp.append(a1)
        temp = sorted(temp)
        return result + temp
        
