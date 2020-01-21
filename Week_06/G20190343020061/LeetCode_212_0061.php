<?php

class Solution
{

    private $res = [];
    private $board;
    private $tries;
    private $m;
    private $n;
    private $visited;

    /**
     * @param String[][] $board
     * @param String[] $words
     * @return String[]
     */
    function findWords($board, $words)
    {
        if (empty($board) || empty($words)) return $this->res;
        $this->board = $board;
        //首先先设置字典树
        $wC = count($words);
        $this->tries = new Tries();
        $tree = $this->tries->getRoot();
        for ($k = 0; $k < $wC; $k++) {
            $this->tries->insert($words[$k]);
        }
        //设置行和高
        $this->m = count($board);
        $this->n = count($board[0]);

        for ($i = 0; $i < $this->m; $i++) {
            for ($j = 0; $j < $this->n; $j++) {
                $this->dfs($i, $j, $tree, "");
            }
        }
        return $this->res;
    }

    public function dfs($i, $j, $tree, $word)
    {
        if ($i <0 || $i>=$this -> m || $j <0 ||
            $j >= $this -> n || $this->visited[$i][$j]) return;
        $this->visited[$i][$j] = true;
        if (empty($tree->links[$this->board[$i][$j]])) {
            $this->visited[$i][$j] = false;
            return;
        }
        $str = $word . $this->board[$i][$j];
        if ($tree->links[$this->board[$i][$j]]->getEnd() &&
            array_search($str, $this->res) === false) {
            $this->res[] = $str;
        }
        $this->dfs($i + 1, $j, $tree->links[$this->board[$i][$j]], $str);
        $this->dfs($i, $j + 1, $tree->links[$this->board[$i][$j]], $str);
        $this->dfs($i - 1, $j, $tree->links[$this->board[$i][$j]], $str);
        $this->dfs($i, $j - 1, $tree->links[$this->board[$i][$j]], $str);
        $this->visited[$i][$j] = false;
    }
}

class Tries
{
    private $root;

    public function __construct()
    {
        $this->root = new TriesNode();
    }

    public function insert($word)
    {
        if (empty($word)) {
            return false;
        }
        $p = $this->root;
        for ($i = 0; $i < strlen($word); $i++) {
            $strLetter = $word{$i};
            if (!$p->containKey($strLetter)) {
                $p->put($strLetter, new TriesNode());
            }
            $p = $p->get($strLetter);
        }
        $p->setEnd();
    }

    public function getRoot()
    {
        return $this->root;
    }
}

class TriesNode
{
    public $links = [];
    private $isEnd = false;


    public function containKey($ch)
    {
        return array_key_exists($ch, $this->links) !== false;
    }

    public function get($ch)
    {
        return $this->links[$ch];
    }

    public function put($ch, $node)
    {
        $this->links[$ch] = $node;
    }

    public function setEnd()
    {
        $this->isEnd = true;
    }

    public function getEnd()
    {
        return $this->isEnd;
    }
}