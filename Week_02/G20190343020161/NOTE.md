# 学习笔记
## hash table
### 构造散列函数
“好的散列函数 = 计算简单 + 分布均匀”。其中计算简单指的是散列函数的计算时间不应该超过其他查找技术与关键字比较的时间，而分布均匀指的是散列地址分布均匀。
1. 直接地址法
2. 数字分析法
3. 平方取中法
4. 折叠法
5. 除留余数法
6. 随机数法

### hash table冲突了怎么办？
- 拉链式解决冲突
- 占位法解决冲突
    
### hash table的时间复杂度
hash表的搜索、插入、删除的平均时间复杂度都为O(1),最坏的情况(每个元素操作时都产生冲突)是O(n)；
## 树
### 树的遍历
- 先序遍历 (pre-order)
- 中序遍历 (in-order)
- 后续遍历 (post-order)

### 结构
        
        def preorder(self, root)
            if root:
                self.traverse_path.append(root.val)
                self.preorder(root.left)
                self.preorder(root.right)
        
        
        def inorder(self, root)
            if root:
               self.inorder(root.left)
               self.traverse_path.append(root.val)
               self.inorder(root.right)
        
        def postorder(self, root)
            if root:
                self.postorder(root.left)
                self.postorder(root.right)
                self.traverse_path.append(root.val)

## 递归
我们算法中遇到的逻辑就那么几种，1. 判断（if-else）2. 循环（loop）3. 递归（recursion）;所以递归在算法学习中是非常重要的。那么对于递归类型的算法我们应该如何思考呢？这里的话我们应该关注两个点：结构和思维。
### 结构
1. 结束条件（recursion terminator）
2. 处理当前层的逻辑（process logic in current level）
3. 下探到下一层（drill down）
4. 清理当前层（reverse the current level status if needed）
    
    
    public void recursion_structure(int level, int param) {
            //terminator
            if (level > MAX_LEVEL) {
                //process result
                return;
            }
    
            //process current logic
            Process(level, param);
    
            //drill down
            recursion_structure(level + 1, param);
    
            //restore current status if needed
        }
        
     
### 思维
1. 不要进行人肉递归（最大的误区）
2. 找最近最简方法，将其拆分为可重复解决的问题
3. 数学归纳法思维
4. 分析的时候，只分析这一层的逻辑，不要人肉探到下一层，将它们看出整体