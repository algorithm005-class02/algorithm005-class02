func reverseBits(num uint32) uint32 {
    var res uint32
    for i:=0;i<32;i++{
        res = res | (((num>>(31-i))&1)<<i)
        
    }
    return res
}