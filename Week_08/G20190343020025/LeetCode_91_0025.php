<?php
// 解码方法


$Solution = new Solution();
$s = "12"; // 2
var_dump($Solution->numDecodings($s));


class Solution
{
    function numDecodings($s)
    {
        if (strlen($s) == 0 || $s == null) return 0;
        $len = strlen($s);
        $s = str_split($s);
        $help = 1;
        $res = 0;
        if ($s[$len - 1] != '0') $res = 1;
        for ($i = $len - 2; $i >= 0; $i--) {
            if ($s[$i] == '0') {
                $help = $res;
                $res = 0;
                continue;
            }
            if (($s[$i] - '0') * 10 + ($s[$i + 1] - 0) <= 26) {
                $res += $help;
                // help 用来存储之前的 res 的值
                $help = $res - $help;
            } else {
                $help = $res;
            }
        }
        return $res;
    }
}