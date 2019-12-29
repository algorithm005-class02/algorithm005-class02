<?php


// 全排列 2
// url https://leetcode-cn.com/problems/permutations-ii/

$nums = [1, 1, 2];
$Solution = new Solution();
print_r($Solution->permute($nums));

class Solution
{
    // 结果
    public $res = [];
    // 判断是否走过了
    public $existed = [];

    // 回溯用法， 归去来兮
    function permute($nums)
    {
        sort($nums);
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
            if (isset($this->existed[$i]) && $this->existed[$i] == 1) continue;
            if ($i > 0 && $nums[$i] == $nums[$i - 1] && $this->existed[$i - 1] == 0) continue;
            $this->existed[$i] = 1;
            array_push($res, $nums[$i]);
            $this->run($res, $nums);
            array_pop($res);
            $this->existed[$i] = 0;
        }
    }

}