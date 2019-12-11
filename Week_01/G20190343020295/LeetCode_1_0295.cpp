class Solution {
public:
	// 双指针	时间复杂度为 O(nlogn)？ 空间复杂度 O(n)
	// 额外的时间消耗，调用一次O(nlogn)的排序函数以及两次时间复杂度为O(n)的查找函数
	// O(nlogn)+O(n)+2*O(n)?
	// 额外的内存消耗，存放排序后的临时数组
	vector<int> twoSum(vector<int>& nums, int target) {
		vector<int> res; 
        if (nums.size() <= 1)
            return res; // 若输入数组中元素少于2，则返回空数组
		vector<int> temp = nums;		// 额外的内存消耗
		sort(temp.begin(), temp.end());	// 排序
		unsigned int front = 0;
		unsigned int back = temp.size() - 1;
		while (front < back) {
			while (front < back && temp[front] + temp[back] < target) {	// 两数之和偏小，前指针后移
				front++;
			}
			while (front < back && temp[front] + temp[back] > target) {	// 两数之和偏大，后指针前移
				back--;
			}
			if (front < back && temp[front] + temp[back] == target) {	// 符合条件
				// 避免结果为不同位置 相同大小的值，故一个从前往后找，一个从后往前找
				res.push_back(findPostion(nums, temp[front]));	
				res.push_back(rfindPostion(nums, temp[back]));	
				return res;
			}
		}
		return res; // 若未找到，返回空数组
	}
	
private:
	// 从前往后查找符合条件的值在原数组中的位置
	int findPostion(vector<int>& nums, int target) {	// 时间复杂度 O(n)
		for (unsigned int i = 0; i < nums.size(); i++)
			if (target == nums[i])
				return i;
		return -1;
	}
	// 从后往前查找符合条件的值在原数组中的位置
    int rfindPostion(vector<int>& nums, int target) {	// 时间复杂度 O(n)
		for (unsigned int i = nums.size() - 1; i >= 0; i--)
			if (target == nums[i])
				return i;
		return -1;
	}

public:
    // 双循环遍历   时间复杂度 O(n^2) 空间复杂度 O(1)
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res; 
        if (nums.size() <= 1)
            return res; // 若输入数组中元素少于2，则返回空数组
        // 最坏情况下，两层循环均要循环nums.size()次
        for (unsigned int i = 0; i <nums.size(); i++) { // 第一层循环，枚举第一个值
            int Vfind = target - nums[i];   // 计算目标值
            for (unsigned int j = i + 1; j <nums.size(); j++) { // 第二层循环，枚举第二个值
                if (Vfind == nums[j]) {  // 判断第二个值是否为目标值
                    res.push_back(i);
                    res.push_back(j);
                    return res;	// 返回结果
                } 
            }
        }
        return res; // 若未找到，返回空数组
    }
	
};