class Solution:

    def rotate(self, nums, k):
        """
        Do not return anything, modify nums in-place instead.
        """
        idx = -1
        new_list = nums.copy()
        for i in range(k-1, -1, -1):
            if i <= len(nums):
                print(i)
                new_list[i] = nums[idx]
                idx -= 1

        for i in range(k + 1):
            if i + k <= len(nums) - 1:
                new_list[i + k] = nums[i]

        nums[:] = new_list[:]

        return None


def main():
    solution = Solution()
    test_case = [
        [[1, 2, 3, 4, 5, 6, 7], 3],
        [[-1, -100, 3, 99], 2],
        [[-1], 2],
        [[1, 2], 3],
    ]
    for i in test_case:
        solution.rotate(i[0], i[1])
        print(i[0])


main()

