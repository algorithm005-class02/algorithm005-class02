class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # 方法一：双指针夹逼（728-752ms）
        '''
        if not nums:
            return []
        n = len(nums)
        nums.sort()
        res = []
        for i in range(n):
            if nums[i] > 0: 
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            l, r = i + 1, len(nums) - 1
            while l < r:
                sum3 = nums[i] + nums[l] + nums[r]
                if sum3 == 0:
                    res.append([nums[i], nums[l], nums[r]])
                    l, r = l + 1, r - 1
                    while l < r and nums[l] == nums[l - 1]: l += 1
                    while l < r and nums[r] == nums[r + 1]: r -= 1
                elif sum3 < 0:
                    l += 1
                else:
                    r -= 1
        return res
        '''
        # 方法二：对双指针的取值范围进行优化（532-544ms）
        '''
        if not nums:
            return []
        n = len(nums)
        nums.sort()
        res = []
        for i in range(n - 2):
            if nums[i] > 0: 
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            l = bisect.bisect_left(nums, - nums[i] - nums[-1], i + 1)
            r = bisect.bisect_right(nums, - nums[i] - nums[i + 1])
            r = min(n - 1, r)
            while l < r:
                sum3 = nums[i] + nums[l] + nums[r]
                if sum3 == 0:
                    res.append([nums[i], nums[l], nums[r]])
                    l, r = l + 1, r - 1
                    while l < r and nums[l] == nums[l - 1]: l += 1
                    while l < r and nums[r] == nums[r + 1]: r -= 1
                elif sum3 < 0:
                    l += 1
                else:
                    r -= 1
        return res
        '''
        # 方法三：参考python最快解（220-236ms）
        counts = {}
        result = []
        # 先统计每个数字的个数
        for num in nums:
            counts[num] = counts.get(num, 0) + 1
        nums = sorted(counts)
        # 遍历数字统计结果
        for i, num in enumerate(nums):
            # 3个0的情况
            if counts[num] > 2 and num == 0:
                result.append([0, 0, 0])
            # a,a,b的情况
            elif counts[num] > 1 and (- num * 2 in counts) and num != 0:
                result.append([num, num, - num * 2])
            # a,b,c的情况
            if num < 0:
                left = bisect.bisect_left(nums, - num - nums[-1], i + 1)
                right = bisect.bisect_right(nums, (- num) // 2, left)
                for num2 in nums[left: right]:
                    num3 = (- num - num2)
                    # num2 != num3 排除已经考虑到的 a,a,b 情况
                    # num2 最大为 -num//2， 所以此处 num3 不可能 = num
                    if num3 in counts and num2 != num3:
                        result.append([num, num2, num3])
        return result
