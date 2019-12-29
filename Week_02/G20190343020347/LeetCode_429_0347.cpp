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
class Solution {
public:
	vector<vector<int>> levelOrder(Node* root) {
		vector<vector<int>> res;
		vector<int> tmp;
		vector<Node *> node_vector;
		if (root == nullptr)
			return res;
		queue<Node *> node_queue;
		node_queue.push(root);
		while (!node_queue.empty()) {
			Node *cur = node_queue.front();
			node_queue.pop();
			tmp.push_back(cur->val);
			for (int i = 0; i<cur->children.size(); ++i) {
				node_vector.push_back(cur->children[i]);
			}
			if (node_queue.empty()/*&&node_vector.size()>0*/) {
				for (auto node : node_vector)
					node_queue.push(node);
				node_vector.clear();
				res.push_back(tmp);
				tmp.clear();
			}
		}
		return res;
	}
};