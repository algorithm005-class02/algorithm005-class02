class Solution
{
    public function reverseBits(int $n)
    {
        $res = 0;
        $co = 32;
        while ($co-- > 0) {
            $res <<= 1;
            $res |= ($n & 1);
            $n >>= 1;
        }
        return $res;
    }
}
