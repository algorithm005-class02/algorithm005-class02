<?php

function selectionSort($arr)
{
    $len = count($arr);
    if ($len <= 0) return $arr;
    for ($i = 0; $i < $len - 1; $i++) {
        $momentIndex = $i;
        for ($j = $i + 1; $j < $len; $j++) {
            if ($arr[$j] < $arr[$momentIndex]) {
                $momentIndex = $j;
            }
        }
        $tmp = $arr[$i];
        $arr[$i] = $arr[$momentIndex];
        $arr[$momentIndex] = $tmp;
    }
    return $arr;
}
