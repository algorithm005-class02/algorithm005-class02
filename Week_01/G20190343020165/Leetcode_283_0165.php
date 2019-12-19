<?php
/**
	移动零
*/
class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        $current = 0;
        foreach($nums as &$value){
            if($value != 0){
                $temp = $nums[$current];
                $nums[$current] = $value;
                $value = $temp;
                $current ++;
            }
        }
    }
}