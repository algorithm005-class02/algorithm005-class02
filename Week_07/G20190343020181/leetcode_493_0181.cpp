class Solution {
public:
    int reversePairs(vector<int>& nums) {
        return mergeSort(nums, 0, nums.size() - 1);
    }

    int mergeSort(vector<int> & arr, int left, int right) {
	    if (left >= right) return 0;
	    int mid = (left + right) >> 1;

	    int cnt = mergeSort(arr, left, mid);
	    cnt += mergeSort(arr, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && (long)arr[i] > (long)arr[j] * (long)2) j++;
            cnt += (j - mid - 1);
        }
	    merge(arr, left, mid, right);
        return cnt;
    }

void merge(vector<int> & arr, int left, int mid, int right) {
	    vector<int> temp(right - left + 1, 0);
	    int i = left, j = mid + 1, k = 0;

	    while (i <= mid && j <= right) {
		    temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
	    }

	    while (i <= mid) temp[k++] = arr[i++];
	    while (j <= right) temp[k++] = arr[j++];

	    for (int p = 0; p < temp.size(); p++)  {
		    arr[left + p] = temp[p];
	    }
    }
};