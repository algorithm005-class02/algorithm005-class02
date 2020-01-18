<?php
class Solution {

    /**
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange($bills) {
        $five = $ten = 0;
        foreach($bills as $value){
            if($value == 5){
                $five ++;
            }else if($value == 10){
                if($five == 0){
                    return false;
                }
                $five--;
                $ten++;
            }else{
                if($five > 0 && $ten > 0){
                    $five--;
                    $ten--;
                }else if($five > 2){
                    $five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}