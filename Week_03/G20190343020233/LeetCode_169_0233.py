class Solution:
    def majorityElement(self, nums):
        target_times = len(nums) / 2
        container = {}
        for num in nums:
            if num not in container:
                container[num] = 1
                if container[num] > target_times:
                    return num
            else:
                container[num] += 1
                if container[num] > target_times:
                    return num

    def majority_element(self, nums):
        return sorted(nums)[len(nums)//2]


if __name__ == '__main__':
    test = Solution()
    print(test.majority_element([3,2,3]))
