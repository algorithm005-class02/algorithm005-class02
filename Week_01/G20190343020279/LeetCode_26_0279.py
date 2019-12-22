'''
@方法：“反向遍历删除”  时间复杂度：O(n)
'''
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        #反向遍历数组（避免数组越界问题）
        for num_index in range(len(nums)-1,0,-1):
            #如果相邻数字相等
            if nums[num_index] == nums[num_index - 1]:
                #则删除该位置的数
                nums.pop(num_index)
        return len(nums)