学习笔记

本周DFS、分治回溯本质上都是递归，都是递归的不同模式，回溯本质上也是DFS。BFS利用Queue的FIFO特性，实现按层次遍历（想波纹扩展）。DFS和树中的先序遍历、后序遍历、中序遍历类似。

递归的要点：一种是傻递归，暴力搜索；另外是聪明的递归，提前剪枝，避免重复解决相同子问题。递归中的状态变量，一种是作为函数的入参，一种是作为全局变量，后者似乎更简洁。


通过二分法，找到旋转数组的中间无序的地方，下面函数将旋转数组恢复为正常排序数组，并记录对应旋转数组的对应index

#+begin_src python
  def resume(nums: List[int]) -> List[int]:
      left, right = 0, len(nums) - 1
      while left <= right:
          mid = (left + right) // 2
          if right - left == 1 and nums[left] > nums[right]:
              index = [e for e in range(right, len(nums))] + [e for e in range(left + 1)]
              return index, nums[right:] + nums[:left + 1]

          if nums[left] > nums[mid]:
              right = mid
          elif nums[mid] > nums[right]:
              left = mid
          else:           # 输入数据不是旋转数组
              break

      return [e for e in range(len(nums))], nums
#+end_src

'
