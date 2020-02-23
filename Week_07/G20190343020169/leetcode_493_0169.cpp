class Solution {
public:
    int reversePairs(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        return merge_sort(nums, 0, nums.size() - 1);
    }

    int merge_sort(vector<int>& nums, int l, int r){
        if(l >= r){
            return 0;
        }
        int mid = l + (r - l) / 2;
        int i = l;
        int count = merge_sort(nums, l, mid) + merge_sort(nums, mid + 1, r);
        for(int j = mid + 1; j <= r; ++j){
            while(i <= mid && (long)nums[i] <= 2 * (long)nums[j]) i++;
            count += mid - i + 1;
        }
        sort(nums.begin() + l, nums.begin() + r + 1);
        return count;
    }

    int reversePairs1(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        return merge_sort1(nums, 0, nums.size() - 1);
    }

    int merge_sort1(vector<int>& nums, int s, int e){
        if(s >= e){
            return 0;
        }
        int mid = s + (e - s) / 2;
        vector<int> cache(e - s + 1);
        int cnt = merge_sort(nums, s, mid) + merge_sort(nums, mid+1, e);
        int i = s, t = s, c = 0;
        for(int j = mid + 1; j <= e; ++j, ++c){
            while(i <= mid && (long) nums[i] <= 2 * (long)nums[j]) i++;
            while(t <= mid && nums[t] < nums[j]) cache[c++] = nums[t++];
            cnt += mid - i + 1;
            cache[c] = nums[j]; 
        }
        while(t <= mid) cache[c++] = nums[t++];
        for (int i = s; i <= e; ++i) {
            nums[i] = cache[i - s];
        }
        return cnt;
    }
};
