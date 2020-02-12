class LRUCache {
public:
    LRUCache(int capacity) : capacity(capacity) {
        
    }
    
    int get(int key) {
        auto iter = key2value.find(key);
        if (iter == key2value.end())
        return -1;
        key_list.erase(iter->second.second);
        key_list.push_front(key);
        iter->second.second = key_list.begin();
        return iter->second.first;
    }
    
    void put(int key, int value) {
         auto iter = key2value.find(key);
        if (iter != key2value.end())
        {
            iter->second.first = value;
            key_list.erase(iter->second.second);
            key_list.push_front(key);
            iter->second.second = key_list.begin();
        }
        else
        {
            key2value[key].first = value;
            key_list.push_front(key);
            key2value[key].second = key_list.begin();
        }
       
        if (key2value.size() > capacity){
            int back_key = key_list.back();
            key2value.erase(back_key);
            key_list.pop_back();
        }
    }

    int capacity = 0;
    list<int> key_list;
    unordered_map<int, pair<int, list<int>::iterator>> key2value;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */