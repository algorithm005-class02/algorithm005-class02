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
执行用时 :140 ms, 在所有 cpp 提交中击败了65.69%的用户
内存消耗 :56.6 MB, 在所有 cpp 提交中击败了11.18%的用户
*/
class Solution {
public:
    vector<int> res;
    vector<int> preorder(Node* root) {
        travel(root);
        return res;
    }
    void travel(Node* root){
        if(root == NULL) return;
        res.push_back(root->val);
        for(int i = 0; i < root->children.size(); i++){
            travel(root->children[i]);
        }

    }
};