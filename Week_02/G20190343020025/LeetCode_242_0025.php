<?php
// 有效的字母异位词
$Solution = new Solution();
$s = "anagram";
$t = "nagaram";
print_r($Solution->isAnagram($s, $t));

class Solution
{

    // 厉害 php 自带的函数偷懒方法
    function isAnagram($s, $t)
    {
        return array_count_values(str_split($s)) == array_count_values(str_split($t));
    }
}