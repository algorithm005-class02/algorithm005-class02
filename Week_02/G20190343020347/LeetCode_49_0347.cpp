//方法1 
//对每个string排序，用hash表存储
class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		unordered_map<string, vector<string>> hash_map;
		vector<vector<string>> result;
		for (auto str : strs) {
			string tmp = str;
			sort(tmp.begin(), tmp.end());
			hash_map[tmp].push_back(str);
		}
		for (auto hashcode : hash_map) {
			result.push_back(hashcode.second);
		}
		return result;
	}
};

//方法2
//记录每个子串的长度，用hashmap存储（速度慢）
class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		unordered_map<string, vector<string>> hash_map;
		vector<vector<string>> result;
		for (auto str : strs)
		{
			int tmp[26] = { 0 };
			for (auto c : str) {
				tmp[c - 'a']++;
			}
			string eachStr = "";
			for (int num : tmp) {
				eachStr += to_string(num);
			}
			hash_map[eachStr].push_back(str);
		}
		for (auto hashcode : hash_map) {
			result.push_back(hashcode.second);
		}
		return result;
	}
};

/****************************************************************/
class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		unordered_map<string, vector<string>> hash;
		for (auto &str : strs) {
			auto temp_str = str;
			sort(temp_str.begin(), temp_str.end());
			hash[temp_str].push_back(str);
		}
		vector<vector<string>> res;
		for (auto &it : hash) {
			res.push_back(std::move(it.second));//这里用移动
		}
		return res;
	}
};
class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		unordered_map<string, vector<string>> mp;
		for (string s : strs) {
			mp[strSort(s)].push_back(s);
		}
		vector<vector<string>> anagrams;
		for (auto p : mp) {
			anagrams.push_back(p.second);
		}
		return anagrams;
	}
private:
	string strSort(string s) {
		int counter[26] = { 0 };
		for (char c : s) {
			counter[c - 'a']++;
		}
		string t;
		for (int c = 0; c < 26; c++) {
			t += string(counter[c], c + 'a');
		}
		return t;
	}
};