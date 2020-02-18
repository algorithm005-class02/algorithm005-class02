<?php

class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function longestValidParentheses($s) {
        $stack = new SplStack();
        $len = strlen($s);
        $stack -> push(-1);
        $res = 0;
        for ($i = 0; $i < $len; $i++) {
            if ($s[$i] == '(') {
                $stack->push($i);
            } else {
                $stack->pop();
                if ($stack -> isEmpty()) {
                    $stack -> push($i);
                } else {
                    $res = max($res, $i - $stack -> top());
                }
            }
        }
        return $res;
    }
}
