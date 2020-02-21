class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if (!root) { return {}; }
        queue<Node*> que;
        que.push(root);
        vector<vector<int>> ret;

        while (!que.empty()) {
            vector<int> tempArray;
            for(int cnt=que.size();cnt;cnt--)
            {
                Node* curr=que.front();
                que.pop();
                tempArray.push_back(curr->val);
                for(Node* it:curr->children)
                    que.push(it);
            }
            ret.push_back(tempArray);
        }

        return ret;
    }
};
