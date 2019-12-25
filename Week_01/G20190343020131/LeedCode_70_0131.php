<?php
class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function climbStairs($n) {
        if ($n == 1) {
            return 1;
        }
        if ($n == 2) {
            return 2;
        }
        $n1 = 1;
        $n2 = 2;
        if ($n > 2) {
            $t = $n - 2;
            while($t){
                $n = $n1 + $n2;
                $n1 = $n2;
                $n2 = $n;
                $t--;
            }
        }
        return $n;
    }
}



?>
