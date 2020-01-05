<?php
// 跳跃游戏

$Solution = new Solution();
$nums =  [2, 3, 1, 1, 4];
var_dump($Solution->canJump($nums));
var_dump($Solution->canJump1($nums));

class Solution
{

    /**
     * @param Integer[] $nums
     * @return Boolean
     */
    function canJump($nums)
    {
        if (empty($nums)) return false;
        $res = 0;
        foreach ($nums as $key => $num) {
            if ($key > $res) return false;
            if ($num + $key > $res) $res = $num + $key;
        }
        return $res >= count($nums) - 1;
    }

    function canJump1($nums)
    {
        if (empty($nums)) return false;
        $lastPos = count($nums) - 1;
        for ($i = count($nums) - 1; $i >= 0; $i--) {
            if ($i + $nums[$i] >= $lastPos) $lastPos = $i;
        }
        return $lastPos == 0;
    }
}
