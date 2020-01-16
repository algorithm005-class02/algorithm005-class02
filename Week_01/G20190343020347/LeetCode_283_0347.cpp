/*
class Solution {
public:
void moveZeroes(vector<int>& nums) {
int m = 0;
for(int i=0;i<nums.size();++i)
{
if(nums[i]!=0)
{
nums[m++] = nums[i];
}
}
for(int i = m;i<nums.size();i++)
{
nums[i] = 0;
}
return;
}
};*/

class Solution {
public:
	void moveZeroes(vector<int>& nums) {
		int cur = 0;
		for (int i = 0; i<nums.size(); ++i) {
			if (nums[i] != 0)
			{
				swap(nums[i], nums[cur++]);
			}
		}
		return;
	}
};
