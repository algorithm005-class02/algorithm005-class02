<?php
//两数之和 
function twoSum($nums, $target) {
    $map = array();
    for ($i = 0; $i < count($nums); $i++) {
        $map[$nums[$i]] = $i;
    }
    for ($i = 0; $i < count($nums); $i++) {
        $m = $target - $nums[$i];
        if (isset($map[$m]) && $map[$m]!= $i) {   //举个例子 [3,2,4] 目标6  不要忘了 可能 返回 [0,0] 多加个条件 $map[$m] != $i
            return [$i, $map[$m]];
        }
    }
    return false;
}






?>
