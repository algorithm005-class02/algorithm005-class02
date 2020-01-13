<?php
function isValid($s) {
    $map = [')'=>'(','}'=>'{',']'=>'['];
        $len = strlen($s);
        if ($len % 2 != 0) return false;      //如果出现 "(" 例子，奇数，直接返回false
        $stack = array();
        for ($i = 0; $i < $len; $i++) {
            if (isset($map[$s[$i]])) {
                if ($map[$s[$i]] != array_pop($stack)) {
                    return false;
                }
            } else {
                array_push($stack, $s[$i]);
            }
        }
        if (count($stack) != 0) {        //如果出现"((((" 例子，判断栈是否为空，不为空返回false
            return false;
        }
        return true;
}














?>
