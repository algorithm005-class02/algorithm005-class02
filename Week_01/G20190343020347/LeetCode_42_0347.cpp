class Solution {
public:
	int trap(vector<int>& height) {
		int result = 0;
		vector<int> left(height.size()), right(height.size());
		for (int i = 1; i<height.size(); i++) {
			left[i] = max(left[i - 1], height[i - 1]);
		}
		for (int i = height.size() - 2; i >= 0; i--) {
			right[i] = max(right[i + 1], height[i + 1]);
		}
		for (int i = 0; i<height.size(); i++) {
			int level = min(left[i], right[i]);
			result += max(0, level - height[i]);
		}
		return result;
	}
};