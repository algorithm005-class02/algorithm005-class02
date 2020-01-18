/**
* Definition for a binary tree node.
* struct TreeNode {
*     int val;
*     TreeNode *left;
*     TreeNode *right;
*     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
* };
*/
//方法1 递归

class Solution {
public:
	vector<int> result;
	vector<int> inorderTraversal(TreeNode* root) {
		if (root != nullptr) {
			inorderTraversal(root->left);
			result.push_back(root->val);
			inorderTraversal(root->right);
		}
		return result;
	}
};
//方法2 借助栈实现
class Solution {
public:
	vector<int> inorderTraversal(TreeNode* root) {
		stack<TreeNode *> rootStack;
		vector<int> result;
		TreeNode* cur = root;
		while (cur != nullptr || !rootStack.empty()) {
			while (cur != nullptr) {
				rootStack.push(cur);
				cur = cur->left;
			}
			cur = rootStack.top();
			rootStack.pop();
			result.emplace_back(cur->val);
			cur = cur->right;
		}

		return result;
	}
};

//方法3 莫里斯遍历
//拿出一个根节点，如果左子树为空则输出该结点
//如果左子树不为空，则放到左子树的最右结点上
class Solution {
public:
	vector<int> inorderTraversal(TreeNode* root) {
		vector<int> result;
		TreeNode *cur = root, *tmp;
		while (cur) {
			tmp = cur->left;
			if (tmp == nullptr) {
				result.push_back(cur->val);
				cur = cur->right;
			}
			else {
				while (tmp->right != nullptr && tmp->right != cur) {
					tmp = tmp->right;
				}
				if (tmp->right == nullptr) {
					tmp->right = cur;
					cur = cur->left;
				}
				else {
					result.push_back(cur->val);
					tmp->right = nullptr;
					cur = cur->right;
				}
			}
		}
		return result;
	}
};

//方法4 用颜色标记，检测到二次标记的元素，直接输出

class Solution {
public:
	vector<int> inorderTraversal(TreeNode* root) {
		vector<int> result;
		stack<pair<int, TreeNode*>> node_stack;
		const int white = 0, green = 1;
		node_stack.push(make_pair(white, root));
		while (!node_stack.empty()) {
			int color = node_stack.top().first;
			TreeNode * tmp = node_stack.top().second;
			node_stack.pop();
			if (tmp == nullptr) {
				continue;
			}
			else {
				if (color == white) {
					node_stack.push(make_pair(white, tmp->right));
					node_stack.push(make_pair(green, tmp));
					node_stack.push(make_pair(white, tmp->left));
				}
				else {
					result.push_back(tmp->val);
				}
			}
		}
		return result;
	}
};