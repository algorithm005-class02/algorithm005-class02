<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        $start = 0;
        $end = count($nums) - 1;
        while($start <= $end){
            $mid = ceil(($start + $end) / 2);
            if($target == $nums[$mid]){
                return $mid;
            }
            //左侧是有序的
            if($nums[$start] <= $nums[$mid]){
                //当前数小于中间数且大于开始数，整个排列有序
                if($target >= $nums[$start] && $target < $nums[$mid]){
                    $end  = $mid - 1;
                }else{
                    $start = $mid + 1;
                }
            }else{
                //当前数大于中间数且小于结束数，整个排列有序
                if($target <= $nums[$end] && $target > $nums[$mid]){
                    $start = $mid + 1;
                }else{
                    $end = $mid - 1;
                }
            }
        }
        return -1;
    }
}