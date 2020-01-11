<?php

// 编辑距离


$word1 = "horse";
$word2 = "ros";
$Solution = new Solution();
var_dump($Solution->minDistance($word1, $word2)); // 3

class Solution
{

    function minDistance($word1, $word2)
    {
        $n1 = strlen($word1);
        $n2 = strlen($word2);
        $dp = [];
        for ($i = 0; $i <= $n1; $i++) $dp[$i][0] = $i;
        for ($i = 0; $i <= $n2; $i++) $dp[0][$i] = $i;

        for ($i = 1; $i <= $n1; $i++) {
            for ($j = 1; $j <= $n2; $j++) {
                $dp[$i][$j] = min(
                    $dp[$i - 1][$j - 1] + ($word1[$i - 1] == $word2[$j - 1] ? 0 : 1),
                    $dp[$i - 1][$j] + 1,
                    $dp[$i][$j - 1] + 1
                );
            }
        }
        return $dp[$n1][$n2];
    }
}
