<?php
 class Solution {

    /**
     * @param Integer[][] $intervals
     * @return Integer[][]
     */
    function merge($intervals) {
        $length = count($intervals);
        if($length<1){
            return [];
        }
        sort($intervals);
        $res = [];
        $j = 0;
        $last = 0;
        foreach($intervals as $val){
            
            if($val[0] <= $last){
                if($last > 0){
                    $val[0] = $res[$j][0];
                }
                $val[1] = max($val[1],$last);
            }else{
                $j++;
            }
            $res[$j] = $val;
            $last = $res[$j][1];
        }
        return $res;
    }
}