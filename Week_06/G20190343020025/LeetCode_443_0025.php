<?php
// 最小基因变化


$start = "AACCGGTT"; // 返回值: 1
$end = "AACCGGTA";
$bank = ["AACCGGTA"];
$Solution = new Solution();
var_dump($Solution->minMutation($start, $end, $bank));

class Solution
{
    // 单向 bfs
    function minMutation($start, $end, $bank)
    {
        if (empty($start) || empty($end) || empty($bank)) return -1;
        $visit = array_pad([0], count($bank), 0);
        $step = 0;
        $queue = new SplQueue();
        $queue->enqueue($start);
        while (!$queue->isEmpty()) {
            $step++;
            $n = $queue->count(); // 确定每次bfs的宽度
            for ($i = 0; $i < $n; $i++) {
                $temp = $queue->dequeue(); // 获得头元素
                for ($j = 0; $j < count($bank); $j++) {
                    if ($visit[$j] == 0) {
                        $diff = 0;
                        for ($k = 0; $k < strlen($temp); $k++) {
                            if ($temp[$k] != $bank[$j][$k]) $diff++;
                        }
                        if ($diff == 1) { // 找到
                            if ($bank[$j] == $end) return $step; // 若该下标j代表的基因为目标基因，则直接返回步长
                            $visit[$j] = 1; // 标记已经访问
                            $queue->enqueue($bank[$j]);
                        }
                    }
                }
            }
        }
        return -1;
    }
}