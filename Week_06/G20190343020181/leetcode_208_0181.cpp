class Trie {
public:
    /** Initialize your data structure here. */
    Trie() {
        root = new TreeNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TreeNode * temp_node = root;
        for (int i = 0; i < word.size(); i++)
        {
            int index = word[i] - 'a';
            if (temp_node->nodes[index] == NULL)
            {
                temp_node->nodes[index] = new TreeNode();
            }
           temp_node = temp_node->nodes[index];
        }
        temp_node->is_End = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TreeNode * temp_node = root;
        for (int i = 0; i < word.size(); i++)
        {
            int index = word[i] - 'a';
            if (temp_node->nodes[index] == NULL)
            {
               return false;
            }
           temp_node = temp_node->nodes[index];
        }
        return temp_node->is_End;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
         TreeNode * temp_node = root;
        for (int i = 0; i < prefix.size(); i++)
        {
            int index = prefix[i] - 'a';
            if (temp_node->nodes[index] == NULL)
            {
               return false;
            }
           temp_node = temp_node->nodes[index];
        }
        return true;
    }

    struct TreeNode{
        TreeNode* nodes[26] = {0};
        bool is_End = false;
    };

    TreeNode* root = NULL;
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */