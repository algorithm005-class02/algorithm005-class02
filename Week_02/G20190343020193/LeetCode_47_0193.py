class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        return list({p for p in itertools.permutations(nums)})