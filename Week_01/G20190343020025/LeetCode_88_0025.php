<?php

class Solution
{
    // php 数组函数的解决方式
    function merge($nums1, $m, $nums2, $n)
    {
        for ($i = $m; $i < count($nums1); $i++) {
            $nums1[$i] = array_shift($nums2);
        }
        sort($nums1);
    }

    function merge1(&$nums1, $m, $nums2, $n)
    {
        $totallength = ($m--) + ($n--) - 1;
        while ($m >= 0 && $n >= 0) {
            $nums1[$totallength--] = $nums2[$n] > $nums1[$m] ? $nums2[$n--] : $nums1[$m--];
        }
        while ($n >= 0) {
            $nums1[$totallength--] = $nums2[$n--];
        }
    }
}

$nums1 = [1, 2, 3, 0, 0, 0];
$m = 3;
$nums2 = [2, 5, 6];
$n = 3;
$Solution = new  Solution();
var_dump($Solution->merge($nums1, $m, $nums2, $n));
var_dump($Solution->merge1($nums1, $m, $nums2, $n));
