<?php
// 移动零

class Solution
{

//    function moveZeroes(&$nums)
//    {
//        foreach ($nums as $key => $num) {
//            if ($num == 0) {
//                unset($nums[$key]);
//                $nums[] = 0;
//            }
//        }
//        return $nums;
//    }

    function moveZeroes1(&$nums)
    {
        $old = count($nums);
        $nums = array_values(array_filter($nums)); // 利用自带的函数去除 所有的零
        $new = count($nums); // 去除零之后的数量
        $diff = $old - $new;
        if ($diff) {
            for ($i = 0; $i < $diff; $i++) {
                $nums[$new + $i] = 0;
            }
        }
        return $nums;
    }
}

$nums = [0, 1, 0, 3, 12];
$Solution = new Solution();
var_dump($Solution->moveZeroes1($nums));