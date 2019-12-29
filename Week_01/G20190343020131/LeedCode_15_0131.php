<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function threeSum($nums) {
        if (count($nums) <3) {
            return [];
        }
        $newArr = [];
        sort($nums);  //排序
        for($i=0; $i < count($nums)-2;$i++){
            if ($nums[$i] > 0) {
                break;
            }
            if ($i > 0 && $nums[$i] == $nums[$i-1]) {  //去重
                continue;
            }
            for ($l=$i+1,$r=count($nums)-1;$l<$r;) {
                if ($nums[$i] + $nums[$l] + $nums[$r] == 0) {
                    $arr = [];
                    $arr[] = $nums[$i];
                    $arr[] = $nums[$l];
                    $arr[] = $nums[$r];
                    $newArr[] = $arr;
                    while($l < $r && $nums[$l+1] == $nums[$l]){  //去重
                        $l++;
                    };  
                    while($l < $r && $nums[$r-1] == $nums[$r]){  //去重
                        $r--;
                    };
                    $l++;
                    $r--;
                }else if($nums[$i] + $nums[$l] + $nums[$r] > 0){
                    $r--;
                }else{
                    $l++;
                }
            } 
        }
        return $newArr;
    }
}
?>
