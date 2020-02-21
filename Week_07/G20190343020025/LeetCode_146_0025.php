<?php
//  LRU缓存机制

class LRUCache
{
    private $capacity;
    private $map = [];
    private $list = [];

    /**
     * @param Integer $capacity
     */
    function __construct($capacity)
    {
        $this->capacity = $capacity;
    }

    /**
     * @param Integer $key
     * @return Integer
     */
    function get($key)
    {
        if (array_key_exists($key, $this->map)) {
            unset($this->list[array_search($key, $this->list)]);
            array_push($this->list, $key);
            return $this->map[$key];
        } else {
            return -1;
        }
    }

    /**
     * @param Integer $key
     * @param Integer $value
     * @return NULL
     */
    function put($key, $value)
    {
        if (array_key_exists($key, $this->map)) {
            unset($this->list[array_search($key, $this->list)]);
        } else {
            if (count($this->list) == $this->capacity) {
                $dkey = array_shift($this->list);;
                unset($this->map[$dkey]);
            }
        }
        $this->map[$key] = $value;
        array_push($this->list, $key);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * $obj = LRUCache($capacity);
 * $ret_1 = $obj->get($key);
 * $obj->put($key, $value);
 */