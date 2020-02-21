package main

// 242.有效字母异位词
//https://leetcode-cn.com/problems/valid-anagram/comments/
//思路：
//时间复杂度：
import "fmt"

func isAnagram(s, t string) bool {
	//判断长度是否相等
	if len(s) != len(t) {
		return false
	}
	a := make([]int, 26)
	//给每个字母在对应的数组中进行统计
	for i := 0; i < len(s); i++ {
		a[s[i]-'a']++
		a[t[i]-'a']--
	}
	for i := 0; i < len(a); i++ {
		if a[i] != 0 {
			return false
		}
	}
	return true
}

func main() {
	flag := isAnagram("anagram", "nagaram")
	fmt.Printf("isAnagram:%v\n", flag)
}
