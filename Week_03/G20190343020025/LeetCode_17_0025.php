<?php
// 电话号码的字母组合

$digits = "23";
$Solution = new Solution();
var_dump($Solution->letterCombinations($digits));

class Solution
{

    public $res = [];
    public $str = '';
    public $alphabet = [
        '2' => ['a', 'b', 'c'],
        '3' => ['d', 'e', 'f'],
        '4' => ['g', 'h', 'i'],
        '5' => ['j', 'k', 'l'],
        '6' => ['m', 'n', 'o'],
        '7' => ['p', 'q', 'r', 's'],
        '8' => ['t', 'u', 'v'],
        '9' => ['w', 'x', 'y', 'z'],
    ];

    function letterCombinations($digits)
    {
        if (!$digits) return [];
        $this->_dfs($digits, 0);
        return $this->res;
    }

    private function _dfs($digits, $step)
    {
        if ($step == strlen($digits)) {
            $this->res[] = $this->str;
            return;
        }
        $key = substr($digits, $step, 1);
        $chars = $this->alphabet[$key];
        foreach ($chars as $char) {
            $this->str .= $char;
            $this->_dfs($digits, $step + 1);
            $this->str = substr($this->str, 0, strlen($this->str) - 1);
        }
    }
}
