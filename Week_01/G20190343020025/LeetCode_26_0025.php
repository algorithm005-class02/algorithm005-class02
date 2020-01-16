<?php


class Solution
{
    function removeDuplicates1(&$nums)
    {
        $len = count($nums);
        if ($len == 0) return 0;
        for ($i = 0; $i < $len - 1; $i++) {
            if ($nums[$i] == $nums[$i + 1]) {
                unset($nums[$i]);
            }
        }
        return count($nums);
    }

    function removeDuplicates(&$nums)
    {
        $len = count($nums);
        if ($len == null) return 0;
        $i = 0;
        for ($j = 1; $j < $len; $j++) {
            $temp = $nums[$j];
            if ($nums[$i] != $temp) {
                $nums[$i + 1] = $temp;
                $i++;
            }
        }
        return $i + 1;
    }
}

$nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
// 返回  [0, 1]
$Solution = new Solution();
var_dump($Solution->removeDuplicates($nums));
var_dump($Solution->removeDuplicates1($nums));
