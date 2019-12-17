<?php
/**
	盛最多水的容器-暴力求解法
*/
class Solution {

    /**
     * @param Integer[] $height
     * @return Integer
     */
    function maxArea($height) {
        $len = count($height);
        $max = 0;
        $low_height = 0;
        for($i=0;$i<$len;$i++){
            for($k=$i;$k<$len;$k++){
                $low_height = min($height[$i],$height[$k]);
                $temp = $low_height * ($k-$i);
                if($temp > $max){
                    $max = $temp;
                } 
            }
        }
        return $max;
    }
}
/**
	盛最多水的容器-优化方法
*/
class Solution {

    /**
     * @param Integer[] $height
     * @return Integer
     */
    function maxArea($height) {
        $r = count($height);
        $l = $max = 0;
        while($l<$r){
            $max = max($max,min($height[$l],$height[$r])*($r-$l));
            if($height[$l] < $height[$r]){
                $l++;
            }else{
                $r--;
            }
        }
        return $max;
    }
}