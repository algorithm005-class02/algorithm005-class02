<?php
// 单词接龙

$beginWord = "hit";
$endWord = "cog";
$wordList = ["hot", "dot", "dog", "lot", "log", "cog"];
$wordList = ["hot", "dot", "dog", "lot", "log"];
// 输出 5
$Solution = new Solution();
var_dump($Solution->ladderLength($beginWord, $endWord, $wordList));


class Solution
{

    /**
     * @param String $beginWord
     * @param String $endWord
     * @param String[] $wordList
     * @return Integer
     */
    function ladderLength($beginWord, $endWord, $wordList)
    {
        if (!in_array($endWord, $wordList)) return 0;
        // 交换数组中的叫和值  hot => 0 ,查询和删除 key 比 value
        $wordKeyValue = array_flip($wordList);
        $beginStr[]  = $beginWord;
        $endStr[]  = $endWord;
        // 双向 BFS
        $n = strlen($beginWord);
        $step = 0;
        while (!empty($beginStr)) {
            $step++;
            // 依次双向 BFS 实现，始终使用变量 beginStr 去进行运算
            if (count($beginStr) > count($endStr)) {
                $temp = $beginStr;
                $beginStr = $endStr;
                $endStr = $temp;
            }
            $str = [];
            foreach ($beginStr as $word1) {
                for ($i = 0; $i < $n; $i++) {
                    $word_1 = $word1;
                    // 循环字母表
                    for ($ch = ord('a'); $ch <= ord('z'); $ch++) {
                        $word_1[$i] = chr($ch);
                        if (in_array($word_1, $endStr)) return $step + 1;
                        if (!array_key_exists($word_1, $wordKeyValue)) continue;
                        unset($wordKeyValue[$word_1]);
                        $str[] = $word_1;
                    }
                }
            }
            $beginStr = $str;
        }
        return 0;
    }
}
