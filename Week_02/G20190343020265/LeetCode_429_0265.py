#
# @lc app=leetcode.cn id=429 lang=python3
#
# [429] N叉树的层序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

# 同理采用层序遍历 BFS遍历算法，同 102题的二叉树层序遍历
# 将左右固定子节点，改为从左到右遍历不定子节点，其余逻辑这里不再赘述
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return
        res, cur_level = [], [root]
        while cur_level:
            temp = []
            next_level = []
            for node in cur_level:
                temp.append(node.val)
                for subnode in node.children:
                    next_level.append(subnode)
            res.append(temp)
            cur_level = next_level
        return res

# 这里记录下算法中迭代、递归的异同点：
# 递归：重复调用函数自身实现循环称为递归；
# 递归实际上不断地深层调用函数，直到函数有返回才会逐层的返回，递归是用栈机制实现的，
# 每深入一层，都要占去一块栈数据区域，因此，递归涉及到运行时的堆栈开销（参数必须压入堆栈保存，
# 直到该层函数调用返回为止），所以有可能导致堆栈溢出的错误；但是递归编程所体现的思想正是
# 人们追求简洁、将问题交给计算机，以及将大问题分解为相同小问题从而解决大问题的动机。
# 例如：if else 调用自己，并在合适时机退出 

# 迭代：利用变量的原值推出新值称为迭代，或着说迭代是函数内某段代码实现循环；
# 迭代大部分时候需要人为的对问题进行剖析，分析问题的规律所在，
# 将问题转变为一次次的迭代来逼近答案。迭代不像递归那样对堆栈有一定的要求，
# 另外一旦问题剖析完毕，就可以很容易的通过循环加以实现。迭代的效率高，但却不太容易理解，
# 当遇到数据结构的设计时，比如图表、二叉树、网格等问题时，使用就比较困难，
# 而是用递归就能省掉人工思考解法的过程，只需要不断的将问题分解直到返回就可以了。
# 例如：for，while循环

# 链接：https://blog.csdn.net/gaoyu1253401563/article/details/82384958
        
# @lc code=end

