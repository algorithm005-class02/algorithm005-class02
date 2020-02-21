<?php
// 搜索二维矩阵


$matrix =  [
    [1,   3,  5,  7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
];
$target = 3;
$Solution = new Solution();
var_dump($Solution->searchMatrix($matrix, $target));
var_dump($Solution->inArray($matrix, $target));

class Solution
{


    function searchMatrix($matrix, $target)
    {
        $len = count($matrix);
        if ($len == 0) return false;
        $count = count($matrix[0]) * $len;
        $left = 0;
        $right = $count - 1;

        while ($left <= $right) {
            $mid = floor(($right + $left) / 2);
            $row = floor($mid / $len);
            $col = floor($mid % $len);
            if ($matrix[$row][$col] == $target) {
                return true;
            } elseif ($matrix[$row][$col] > $target) {
                $right = $mid - 1;
            } else {
                $left = $mid + 1;
            }
        }
        return false;
    }


    function inArray($matrix, $target)
    {
        foreach ($matrix as $m) {
            if (in_array($target, $m)) {
                return true;
            }
        }
        return false;
    }
}
