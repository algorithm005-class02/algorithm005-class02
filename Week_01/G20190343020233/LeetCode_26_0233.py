class Solution:
    def removeDuplicates(self, nums):
        i = 1
        while i < len(nums):
            if nums[i] == nums[i-1]:
                del nums[i]
            else:
                i += 1
        return nums

    def removeDuplicates_set(self, nums):
        return (list(set(nums)))

if __name__ == '__main__':
    test = Solution()
    print(test.removeDuplicates_set([1,1,2]))
    print(test.removeDuplicates_set([0,0,1,1,1,2,2,3,3,4]))
    print(test.removeDuplicates_set([1,1]))