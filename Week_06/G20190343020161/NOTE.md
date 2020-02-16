# 学习笔记 
## AVL树
- AVL树是平衡的二叉搜索树 
- 平衡因子(Balance Factory):它左子树减去右子树的高度(有时相反)
Balance Factory = {-1, 0, 1} 
- 通过旋转操作来达到平衡(左旋、右旋、左右旋、右左旋) 

缺点：节点需要存储额外信息，且调整次数频繁； 


### 回顾一下树的遍历
        
       def preOrder(self, root):       
       if root:
            self.traverse_path.append(root.val)
            self.preOrder(root.left)
            self.preOrder(root.right)
        
       def inOrder(self, root)   
       if root:
            self.inOrder(root.left)
            self.traverse_path.append(root.val)
            self.inOrder(root.right)
       
       def postOrder(self, root):       
       if root:
            self.postOrder(root.left)
            self.postOrder(root.right)
            self.traverse_path.append(root.val)
       
### 二叉搜索树 
二叉搜索树又称为有序二叉树、排序二叉树，它有以下几个特点： 
1. 左子树上所有节点的值均小于它的根节点的值；
2. 右字数上所有节点的值均大于它的跟节点的值；
3. 由此类推：左右子树也分别树二叉排序树；

二叉搜索树的查询效率和它树的高度有关，所以就引入了平衡二叉树；
## 红黑树 
红黑树是一种**近似平衡**的二叉搜索树(Binary Search Tree)，它能确保任何一个结点的左右子树的高度差小于两倍。
具体来说，红黑树是满足一下条件的二叉搜索树：
- 每个节点要么红色，要么黑色；
- 根节点是黑色；
- 每个叶子节点(NIL节点，空节点)是黑色的；
- 
