<?php
//  N皇后

$n = 4;
$Solution = new Solution();
var_dump($Solution->solveNQueens($n));

class Solution
{
    public $res = [];
    public $cols = []; // 列
    public $pie = []; // 撇
    public $na = [];  // 纳

    function solveNQueens($n)
    {
        if ($n < 1) return [];
        $this->queens($n, 0, []);
        return $this->gen($n);
    }

    function queens($n, $i, $curState)
    {
        if ($i == $n) {
            array_push($this->res, $curState);
            return;
        }
        for ($j = 0; $j < $n; $j++) {
            if (
                in_array($j, $this->cols)
                || in_array($i + $j, $this->pie)
                || in_array($i - $j + $n, $this->na)
            ) {
                continue;
            }
            array_push($this->cols, $j);
            array_push($this->pie, $i + $j);
            array_push($this->na, $i - $j + $n);
            $curState[$i] = $j;
            $this->queens($n, $i + 1, $curState);
            array_pop($this->cols);
            array_pop($this->pie);
            array_pop($this->na);
        }
    }

    function gen($n)
    {
        $ret = [];
        if (!empty($this->res)) {
            foreach ($this->res as $v) {
                for ($i = 0; $i < $n; $i++) {
                    $str = '';
                    foreach ($v as $val) {
                        if ($val == $i) {
                            $str .= 'Q';
                        } else {
                            $str .= '.';
                        }
                    }
                    array_push($ret, $str);
                }
            }
        }
        return array_chunk($ret, $n);
    }
}
