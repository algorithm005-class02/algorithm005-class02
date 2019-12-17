<?php

/**
 * 两数之和
 *
 */



class Solution
{
    // 新建一个数组，存放结果减去每次循环的某个值，得到差值，并查询原数组中，是否存在这个差值
    function twoSum($nums, $target)
    {
        $arr = [];
        for ($i = 0; $i < count($nums); $i++) {
            $diffValue = $target - $nums[$i];
            //  if (array_key_exists($diff, $arr))  这样子也可以
            if (isset($arr[$diffValue])) {
                return [$arr[$diffValue], $i];
            }
            $arr[$nums[$i]] = $i;
        }
    }

    // 暴力循环法
    function twoSum1($nums, $target)
    {
        $res = [];
        $len = count($nums);
        for ($i = 0; $i < $len - 1; $i++) {
            for ($j = $i + 1; $j < $len; $j++) {
                if ($nums[$i] + $nums[$j] == $target) {
                    $res = [$i, $j];
                    return $res;
                }
            }
        }
    }
}

$nums = [2, 7, 11, 15];
$target = 9;
// 返回  [0, 1]
$Solution = new Solution();
var_dump($Solution->twoSum($nums, $target));
var_dump($Solution->twoSum1($nums, $target));