<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums) {
        $len = count($nums);
        if ($len == 1) {
            return 1;
        }
        $cur = 0;
        for ($i = 1; $i < $len;$i++) {
            if ($nums[$i] != $nums[$cur]) {
                $nums[$cur+1] = $nums[$i];
                $cur++;
            }
        }
        return $cur+1;
    }
}
