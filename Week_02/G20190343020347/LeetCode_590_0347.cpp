//N叉树的后序遍历
/*
// Definition for a Node.
class Node {
public:
int val;
vector<Node*> children;

Node() {}

Node(int _val) {
val = _val;
}

Node(int _val, vector<Node*> _children) {
val = _val;
children = _children;
}
};
*/
//方法1：dfs
class Solution {
public:
	vector<int> postorder(Node* root) {
		vector<int> res;
		dfs(root, res);
		return res;
	}
	void dfs(Node* root, vector<int> &res) {
		if (root == nullptr)
			return;
		for (int i = 0; i<root->children.size(); ++i)
		{
			dfs(root->children[i], res);
		}
		res.push_back(root->val);
		return;
	}
};
//方法2：栈模拟

class Solution {
public:
	vector<int> postorder(Node* root) {
		vector<int> res;
		stack<Node *> node_stack;
		if (root == nullptr)
			return res;
		node_stack.push(root);
		while (!node_stack.empty())
		{
			Node* cur = node_stack.top();
			node_stack.pop();
			res.push_back(cur->val);
			for (int i = 0; i<cur->children.size(); ++i) {
				node_stack.push(cur->children[i]);
			}
		}
		reverse(res.begin(), res.end());
		return res;
	}
};
//方法3 标记法
class Solution {
public:
	vector<int> postorder(Node* root) {
		vector<int> res;
		const int white = 0, green = 1;
		stack<pair<int, Node*>> node_stack;
		node_stack.push(make_pair(white, root));
		while (!node_stack.empty()) {
			int color = node_stack.top().first;
			Node *cur = node_stack.top().second;
			node_stack.pop();
			if (cur == nullptr)
				continue;
			if (color == white) {
				node_stack.push(make_pair(green, cur));
				for (int i = cur->children.size() - 1; i >= 0; --i)
					node_stack.push(make_pair(white, cur->children[i]));
			}
			else {
				res.push_back(cur->val);
			}
		}
		return res;
	}
};
