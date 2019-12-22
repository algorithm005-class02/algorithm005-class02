<?php
class Solution {

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        $return = [];
        foreach($strs as $value){
            $k = $this->sortArr($value);
            $return[$k][] = $value;
        }

        return $return;
    }

    function sortArr($str){
        $arr = str_split($str,1);
        asort($arr);
        return join('',$arr);
    }
}