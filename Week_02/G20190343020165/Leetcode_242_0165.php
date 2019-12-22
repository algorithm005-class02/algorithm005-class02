<?php
class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        if(strlen($s) != strlen($t)){
            return false;
        }
        $a = str_split($s,1);
        $b = str_split($t,1);
		$counter = [];
        foreach($a as $key => $value){
			if(!isset($counter[$a[$key]])){
				$counter[$a[$key]] = 0;
			}
			if(!isset($counter[$b[$key]])){
				$counter[$b[$key]] = 0;
			}
            $counter[$a[$key]]++;
            $counter[$b[$key]]--;
        }
        foreach($counter as $v){
            if($v != 0){
                return false;
            }
        }
        return true;
    }
}