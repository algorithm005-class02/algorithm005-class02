<?php


class Solution {
    private $m;//列
    private $n;//行
    private $market;
    private $board ;
    private $word;
    private $direction = [[-1,0],[0,-1],[0,1],[1,0]];
    function exist($board, $word) {
        if (empty($board) || empty($word)) return false;
        $this -> board = $board;
        $this -> word = $word;
        $this -> m = count($board);
        $this -> n = count($board[0]);

        for ($i = 0; $i < $this -> m ;$i++) {
            for ($j = 0; $j < $this -> n; $j++) {
                if ($this -> dfs($i, $j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private function  dfs($i, $j, $start) {
        if ($start == (strlen($this -> word) -1)) {
            return $this -> board[$i][$j] == $this -> word{$start};
        }
        if ($this -> board[$i][$j] == $this -> word{$start}) {
            $this -> market[$i][$j] = true;
            for ($k =0; $k < 4; $k++) {
                $newX = $i + $this -> direction[$k][0];
                $newY = $j + $this -> direction[$k][1];
                if ($this -> inArea($newX, $newY) && !$this -> market[$newX][$newY]) {
                    if ($this -> dfs($newX, $newY, $start+1)) {
                        return true;
                    }
                }
            }
            $this -> market[$i][$j] = false;
        }
        return false;
    }

    private function inArea($x, $y) {
        return $x >=0 && $x < $this ->  m && $y >=0 && $y < $this -> n;
    }
}