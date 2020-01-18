<?php
//  字母异位词分组

$Solution = new Solution();
$strs = ["eat", "tea", "tan", "ate", "nat", "bat"];
/**
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
print_r($Solution->groupAnagrams($strs));
print_r($Solution->groupAnagrams1($strs));

class Solution
{

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs)
    {
        $resArr = [];
        $prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103];
        foreach ($strs as $str) {
            $strlen = 1;
            for ($i = 0; $i < strlen($str); $i++) {
                $strlen *= $prime[ord($str[$i]) - 97];
            }
            $resArr[$strlen][] = $str;
        }
        return $resArr;
    }

    // 先转为数组，然后在排序正常进行匹配
    function groupAnagrams1($strs)
    {
        $resArr = [];
        foreach ($strs as $str) {
            $sourceStr = str_split($str);
            sort($sourceStr);
            $sourceStr = implode(',', $sourceStr);
            $resArr[$sourceStr][] = $str;
        }
        return $resArr;
    }
}