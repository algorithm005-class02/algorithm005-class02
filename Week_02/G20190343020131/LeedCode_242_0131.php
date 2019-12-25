<?php
//hash求解方法
class Solution {
//暴力求解法
	function isAnagram($s, $t) {
    $s_len = strlen($s);
    $t_len = strlen($t);
    if ($s_len != $t_len) {
        return false;
    }
    if ($s_len == 1 && $s != $t) {
        return false;
    }
    $s_arr = str_split($s);
    $t_arr = str_split($t);
    sort($s_arr);
    sort($t_arr);
    if (implode($s_arr) != implode($t_arr)) {
        return false;
    }
    return true;

}
    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        $s_len = strlen($s);
        $t_len = strlen($t);
        if ($s_len != $t_len) {
            return false;
        }
        $s_map = array();
        for ($i = 0 ; $i < $s_len ; $i++) {
            if (isset($s_map[$s[$i]])) {
                $s_map[$s[$i]] += 1;
            }else{
                $s_map[$s[$i]] = 1;
            }
        }
        $t_map = array();
        for ($i = 0 ; $i < $s_len ; $i++) {
            if (isset($s_map[$t[$i]])) {
                $t_map[$t[$i]] += 1;
            }else{
                $t_map[$t[$i]] = 1;
            }
        }
        foreach ($t_map as $key => $value) {
            if (!isset($s_map[$key]) || ($s_map[$key] != $value)) {
                return false;
            }
        }
        return true;

    }
}

?>
