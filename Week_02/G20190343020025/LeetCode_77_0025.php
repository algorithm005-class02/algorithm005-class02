<?php

$Solution = new Solution();
$n = 4;
$k = 2;
print_r($Solution->combine($n,$k));
class Solution
{

    private $combs = [];

    function combine($n, $k)
    {
        $this->combine11([], 1, $n, $k);
        return $this->combs;
    }

    private function combine11($comb, $start, $n, $k)
    {
        if ($k == 0) {
            array_push($this->combs, $comb);
            return;
        }
        for ($i = $start; $i <= $n; $i++) {
            array_push($comb, $i);
            $this->combine11($comb, $i + 1, $n, $k - 1);
            array_pop($comb);
        }

    }
}