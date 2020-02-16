<?php
// 字符串转换整数 (atoi)

$str =  "42"; //42
$str = "   -42"; // -42
$Solution = new Solution();
var_dump($Solution->myAtoi($str));
class Solution
{

    /**
     * @param String $str
     * @return Integer
     */
    function myAtoi($str)
    {
        $max = pow(2, 31) - 1;
        $min = pow(-2, 31);
        $str = ltrim($str);
        if (($str[0] == '-' || $str[0] == '+') && !is_numeric($str[1])) return 0;
        if (($str[0] != '-' && $str[0] != '+') && !is_numeric($str[0])) return 0;

        $prex = 1;
        if ($str[0] == '-') {
            $prex = -1;
            $str = ltrim($str, "-");
        } else {
            $str = ltrim($str, "+");
        }
        $res = 0;
        for ($i = 0; $i < strlen($str); $i++) {
            if (!is_numeric($str[$i])) break;
            $res = $res * 10 + (int)($str[$i]);
        }
        $res = $res * $prex;
        if ($res > $max) return $max;
        if ($res < $min) return $min;
        return $res;
    }
}


