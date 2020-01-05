class Solution {
public:
	bool lemonadeChange(vector<int>& bills) {
		int five = 0, ten = 0;
		for (auto num : bills) {
			if (num == 5) five++;
			else if (num == 10 && five>0) { ten++; five--; }
			else if (ten>0 && five>0) { ten--; five--; }
			else if (five>2) { five -= 3; }
			else return false;
		}
		return true;
	}
};