<?php
// 柠檬水找零


$Solution = new Solution();
$bills = [5, 5, 5, 10, 20];
$bills = [10, 10];
var_dump($Solution->lemonadeChange($bills));
class Solution
{

    /**
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange($bills)
    {
        $five = 0;
        $ten = 0;
        foreach ($bills as $bill) {
            if ($bill == 5) {
                $five += 1;
            } elseif ($bill == 10) {
                if ($five == 0) return false;
                $five -= 1;
                $ten += 1;
            } else {
                if ($ten > 0 && $five > 0) {
                    $ten -= 1;
                    $five -= 1;
                } elseif ($five >= 3) {
                    $five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
