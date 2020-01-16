class Solution {
public:
	vector<int> plusOne(vector<int>& digits) {
		int c = 1;
		vector<int> result;
		for (int i = digits.size() - 1; i >= 0; i--)
		{
			int digit = digits[i];
			digit += c;
			if (digit == 10)
			{
				c = 1;
				digits[i] = 0;
			}
			else
			{
				c = 0;
				digits[i] = digit;
				break;
			}
		}
		if (c == 1)
		{
			result.push_back(c);
		}
		for (int i = 0; i<digits.size(); ++i)
		{
			result.push_back(digits[i]);
		}
		return result;
	}
};