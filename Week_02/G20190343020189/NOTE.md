# Week2 notes

## hashTable

## Tree & BST

- Tree & graph
    - typical 2D data structure
    - level, root, parent, child, sibling, leaf
    - binary tree - used most frequently
    - cycle: the core difference between tree & graph (with cycle)
        - linked list - special tree
        - tree - special graph
    - why tree?
        - more similar to real life problem (e.g. decision tree, state tree, life tree)
    - tree traversal:
        - preorder - root, left, right
        - inorder - left, root, right
        - postoder - left, right, root
- Binary search tree
    - why BST: search O(n) ⇒ O(logn)
    - definition:
        1. The left subtree of a node contains only nodes with keys lesser than the node's key
        2. The right subtree of a node contains only nodes with keys greater than the node's key
        3. the left and right subtree each must also be a BST
    - result of inorder traverse is in ascending order
    - common problems:
        - search for a node
        - insert a node: 1) try to find 2) traverse till end 3) insert right there
        - delete:
            - leaf node can be deleted directly
            - replace other node with its inorder traversal successor
        - degradation: worst case → linked list
- Practice
    - tree traversal demo app:

    [](https://visualgo.net/zh/bst)

    - homework
        - [https://leetcode-cn.com/problems/binary-tree-inorder-traversal/](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
        - [https://leetcode-cn.com/problems/binary-tree-preorder-traversal/](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
        - [https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)
        - [https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description)
        - [https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

## Recursion

- why handy for tree:
    - repetition is defined into the data structure
- metaphor: inception, onion
- template

        def recursion(level, param1, param2, ...):
        	# recursion terminator
        	if level > MAX_LEVEL:
        		process_result
        		return
        
        	# process logic in current level
        	process(level, data...)
        
        	# drill down
        	self.recursion(level + 1, p1, ...)
        
        	# reverse the current level status if needed

- 3 key points
    - abandon manual recursion
    - find the closest, repetitive, sub problem
    - mathematical induction
- practice:
    - [https://leetcode-cn.com/problems/climbing-stairs/](https://leetcode-cn.com/problems/climbing-stairs/)
    - [https://leetcode-cn.com/problems/generate-parentheses/](https://leetcode-cn.com/problems/generate-parentheses/)
    - [https://leetcode-cn.com/problems/invert-binary-tree/description/](https://leetcode-cn.com/problems/invert-binary-tree/description/)
    - [https://leetcode-cn.com/problems/validate-binary-search-tree](https://leetcode-cn.com/problems/validate-binary-search-tree)
    - [https://leetcode-cn.com/problems/maximum-depth-of-binary-tree](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)
    - [https://leetcode-cn.com/problems/minimum-depth-of-binary-tree](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree)
    - [https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)
- homework
    - [https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
    - [https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)
    - [https://leetcode-cn.com/problems/combinations/](https://leetcode-cn.com/problems/combinations/)
    - [https://leetcode-cn.com/problems/permutations/](https://leetcode-cn.com/problems/permutations/)
    - [https://leetcode-cn.com/problems/permutations-ii/](https://leetcode-cn.com/problems/permutations-ii/)