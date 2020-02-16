<?php


class Solution
{
    /**
     * @param String $s
     * @return String
     */
    function reverseWords($s)
    {
        $len = strlen($s);
        if ($len <= 0) return $s;
        $res = '';
        $tmp = '';
        $stack = new SplStack();
        for ($i = 0; $i < $len; $i++) {
            if ($s[$i] == ' ') {
                if (strlen($tmp) != 0) {
                    $stack->push($tmp);
                    $tmp = '';
                }
            } else if ($i == $len - 1) {
                $tmp .= $s[$i];
                $stack->push($tmp);
            } else {
                $tmp .= $s[$i];
            }
        }
        if ($stack->isEmpty()) return "";
        $res = $res . $stack->pop();
        while (!$stack->isEmpty()) {
            $res .= " " . $stack->pop();
        }
        return $res;
    }
}
