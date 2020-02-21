class Solution:
    def permuteUnique(self, nums):
        '''

        1、在开始回溯算法之前，对数组进行一次排序操作，这是上面多次提到的；

        2、在进入一个新的分支之前，看一看这个数是不是和之前的数一样，如果这个数和之前的数一样，并且之前的数还未使用过，那接下来如果走这个分支，就会使用到之前那个和当前一样的数，就会发生重复，此时分支和之前的分支一模一样。
        https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
        :param nums:
        :return:
        '''
        if len(nums) == 0:
            return []

        # 修改 1：首先排序，之后才有可能发现重复分支，升序、倒序均可
        nums.sort()
        # nums.sort(reverse=True)

        used = [False] * len(nums)
        res = []
        self.__dfs(nums, 0, [], used, res)
        return res

    def __dfs(self, nums, index, pre, used, res):
        if index == len(nums):
            res.append(pre.copy())
            return
        for i in range(len(nums)):
            if not used[i]:
                # 修改 2：因为排序以后重复的数一定不会出现在开始，故 i > 0
                # 和之前的数相等，并且之前的数还未使用过，只有出现这种情况，才会出现相同分支
                # 这种情况跳过即可
                if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                    continue
                used[i] = True
                pre.append(nums[i])
                self.__dfs(nums, index + 1, pre, used, res)
                used[i] = False
                pre.pop()
