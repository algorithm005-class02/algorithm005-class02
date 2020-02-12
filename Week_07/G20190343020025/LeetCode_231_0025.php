<?php
// 2的幂

$Solution = new Solution();
$n = 16; // true
$n = 218; // false;
var_dump($Solution->isPowerOfTwo($n));
var_dump($Solution->isPowerOfTwo1($n));

class Solution
{

    /**
     * @param Integer $n
     * @return Boolean
     */
    function isPowerOfTwo($n)
    {
        return $n > 0 && ($n & ($n - 1)) == 0;
    }

    function isPowerOfTwo1($n)
    {
        if ($n == 1) return true;
        if ($n == 0) return false;
        if ($n / 2 === 0) {
            return true;
        } else {
            if ($n / 2 > 0) {
                if ($this->isPowerOfTwo($n / 2) == true) {
                    return true;
                }
            }
            return false;
        }
    }
}