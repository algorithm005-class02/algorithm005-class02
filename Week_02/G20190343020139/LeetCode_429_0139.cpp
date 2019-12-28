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
执行用时 :72 ms, 在所有 cpp 提交中击败了98.91%的用户
内存消耗 :57.4 MB, 在所有 cpp 提交中击败了5.23%的用户
*/
class Solution {
public:
    queue<Node*> q;
    vector<vector<int>> res;
    vector<vector<int>> levelOrder(Node* root) {
        if(root == NULL) return {};
        q.push(root);
        while(!q.empty()){
            vector<int> v;
            Node *node;
            for(int i = q.size(); i > 0; i--){
                node = q.front();
                v.push_back(node->val);
                q.pop();
                for(int j = 0; j < node->children.size(); j++){
                    q.push(node->children[j]);
                }
            }
            res.push_back(v);
        }
        return res;
    }
};