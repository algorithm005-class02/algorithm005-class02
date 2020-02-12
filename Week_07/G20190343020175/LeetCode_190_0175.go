package main

func reverseBits(num uint32) uint32 {
	ret := uint32(0)
	for i := uint32(0); i < 32; i++ {
		if num&(uint32(1)<<i) != 0 {
			ret |= 1 << (31 - i)
		}
	}
	return ret
}
