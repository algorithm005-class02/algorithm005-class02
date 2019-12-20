#学习笔记
##树
###树的遍历
树的遍历有三种方法，分别是前序中序后续遍历。  

前序遍历的伪代码  
```python
def preorder(self,root):
  if root:
     self.traverse_path.append(root.val)
     self.preorder(root.left)
     self.preforder(root.right)
```
中序遍历递归代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    List<Integer> visited = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            visit(root);
            inorderTraversal(root.right);
        }
        return visited;
    }
    public void visit(TreeNode node){
        visited.add(node.val);
    }
}
```


中序遍历非递归代码
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
```


后序遍历的伪代码

```python
def postoder(self,root):
  if root:
     self.postorder(root.left)
     self.postorder(root.right)
     self.traverse_path.append(root.val)
```

##递归

递归是自己调用自己，递归时必须要有明确的结束条件。递归是归纳演绎法的一种表现。


###递归模板

```java
public void recur(int level, int param) { 

  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 

  // process current logic 
  process(level, param); 

  // drill down 
  recur( level: level + 1, newParam); 

  // restore current status 
 
}

```

###尾递归

首先进行计算，将当前步骤传递给下一个递归步骤，这导致最后一个语句采用的形式（return recursive_func(delta_param).
 ）  
尾调用很重要的特性就是它可以不在调用栈上面添加一个新的堆栈帧，而是更新它。

举个例子：  
这是常规递归
```java
int FibonacciRecursive(int n)
{
     if( n < 2)
         return n;
     return (FibonacciRecursive(n-1)+FibonacciRecursive(n-2));
}

```

这是尾递归
```java
int FibonacciTailRecursive(int n,int ret1,int ret2)
{
    if(n==0)
       return ret1; 
     return FibonacciTailRecursive(n-1,ret2,ret1+ret2);
}
```