<?php
// 岛屿数量

$grid = [
    ["1", "1", "1", "1", "0"],
    ["1", "1", "0", "1", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "0", "0", "0"]
];
// 输出 5
$Solution = new Solution();
var_dump($Solution->numIslands($grid));
var_dump($Solution->bfs($grid));

class Solution
{

    /**
     * @param String[][] $grid
     * @return Integer
     */
    private $numIslands = 0;
    private   $grid = [];
    // DFS  解法
    function numIslands($grid)
    {
        if (empty($grid)) return 0;
        $this->grid = $grid;
        foreach ($this->grid as $key => $value) {
            foreach ($value as $k => $v) {
                if ($this->grid[$key][$k] == 1) {
                    $this->numIslands++;
                    $this->dfs($key, $k);
                }
            }
        }
        return $this->numIslands;
    }
    private function dfs($i, $j)
    {
        if (empty($this->grid[$i][$j]) || $this->grid[$i][$j] != 1) return;
        $this->grid[$i][$j] = 3;
        $this->dfs($i + 1, $j);
        $this->dfs($i - 1, $j);
        $this->dfs($i, $j + 1);
        $this->dfs($i, $j - 1);
    }

    private $queue = [];
    private $num = 0;
    public function bfs($grid)
    {
        foreach ($grid as $key => $value) {
            foreach ($value as $k => $item) {
                if ($grid[$key][$k] == 1) {
                    $this->num++;
                    $this->queue[] = [$key, $k];
                }
            }
        }

        while (!empty($this->queue)) {
            $i = end($this->queue)[0];
            $j = end($this->queue)[1];
            array_pop($this->queue);
            $grid[$i][$j] = 3;
            $arr = [
                [$i - 1, $j],
                [$i + 1, $j],
                [$i, $j - 1],
                [$i, $j + 1],
            ];
            foreach ($arr as $item) {
                $key = reset($item);
                $k = end($item);
                if (empty($grid[$key][$k]) || $grid[$key][$k] != 1) continue;
                $grid[$key][$k] = 3;
                $this->num--;
                $this->queue[] = [$key, $k];
            }
        }
        return $this->num;
    }
}
