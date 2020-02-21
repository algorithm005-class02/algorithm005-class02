<?php
// 反转字符串 II

$s = "abcdefg";
$k = 2;// "bacdfeg"
$Solution = new Solution();
var_dump($Solution->reverseStr($s, $k));

class Solution
{


    function reverseStr($s, $k)
    {
        for ($i = 0, $length = strlen($s); $i < $length; $i += 2 * $k) {
            $l = $i;
            $r = $l + $k - 1;
            isset($s[$r]) ?: $r = $length - 1;
            while ($l < $r) {
                $tmp = $s[$l];
                $s[$l] = $s[$r];
                $s[$r] = $tmp;
                $l++;
                $r--;
            }
        }
        return $s;
    }
}
