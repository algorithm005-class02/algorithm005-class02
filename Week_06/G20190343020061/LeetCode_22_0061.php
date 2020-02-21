<?php

class Solution {

    private $res;

    /**
     * @param Integer $n
     * @return String[]
     */
    function generateParenthesis($n) {
        $this -> helper(0,0,$n,"");
        return $this -> res;
    }

    function helper($left, $right, $n, $str) {
        if (($left == $n) && ($right == $n)) {
            $this -> res[] = $str;
            return ;
        }
        if ($left < $n) {
            $this -> helper($left+1, $right,$n,$str . "(");
        }
        if ($right < $left) {
            $this -> helper($left, $right+1, $n, $str . ")");
        }
    }
}