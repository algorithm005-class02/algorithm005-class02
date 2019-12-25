<?php

// 全排列
// url https://leetcode-cn.com/problems/permutations/

$nums = [1, 2, 3];
$Solution = new Solution();
print_r($Solution->permute($nums));

class Solution
{
    public $res = [];

    // 回溯用法， 归去来兮
    function permute($nums)
    {
        $this->run([], $nums);
        return $this->res;
    }

    private function run($res, $nums)
    {
        if (count($res) == count($nums)) {
            array_push($this->res, $res);
            return;
        }
        for ($i = 0; $i < count($nums); $i++) {
            if (in_array($nums[$i], $res)) continue;
            array_push($res, $nums[$i]);
            $this->run($res, $nums);
            array_pop($res);
        }
    }

}