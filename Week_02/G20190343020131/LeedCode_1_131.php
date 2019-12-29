<?php
/**
 * @param Integer[] $nums
 * @param Integer $target
 * @return Integer[]
 */
function twoSum($nums, $target) {
    $map = array();
    for ($i = 0 ; $i < count($nums) ; $i++) {
        $map[$nums[$i]] = $i;
    }
    for ($i = 0 ; $i < count($nums) ; $i++) {
        $complement = $target-$nums[$i];
        if (isset($map[$complement]) && $i != $map[$complement]) {
            return [$i,$map[$complement]];
        }
    }
}
$a = twoSum([3,3],6);
var_dump($a);die;





?>