<?php

// 比特位计数

$Solution = new Solution();
$num = 2; //[0,1,1]
$num = 5; // [0,1,1,2,1,2];
var_dump($Solution->countBits($num));

class Solution {

    /**
     * @param Integer $num
     * @return Integer[]
     */
    function countBits($num) {
        $res[] = 0;
        for ($i = 1; $i <= $num; $i++) {
            $res[$i] = $res[(int)$i / 2] + $i % 2;
        }
        return $res;
    }
}