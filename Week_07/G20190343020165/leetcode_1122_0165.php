<?php
class Solution {

    /**
     * @param Integer[] $arr1
     * @param Integer[] $arr2
     * @return Integer[]
     */
    function relativeSortArray($arr1, $arr2) {
        $hash1 = [];
        foreach($arr1 as $value){
            if(empty($hash1[$value])){
                $hash1[$value] = 1;
            }else{
                $hash1[$value] ++;
            }
        }
        $diff = array_diff($arr1,$arr2);
        sort($diff);
        $return1 = [];
        foreach($arr2 as $val){
            if(isset($hash1[$val])){
                for($i=0;$i<$hash1[$val];$i++){
                    $return1[] = $val;
                }
            }
        }
         
        return array_merge($return1,$diff);
    }
}