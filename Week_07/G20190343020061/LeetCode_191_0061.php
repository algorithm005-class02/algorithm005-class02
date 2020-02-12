class Solution {
    public function hammingWeight(int $n) {
        $co = 0;
        while ($n != 0) {
            $co++;
            $n &= $n-1;
        }
        return $co;
    }
}
