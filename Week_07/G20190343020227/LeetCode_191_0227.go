func hammingWeight(num uint32) int {
    var sum int = 0
    for num!=0{
        sum++
        num = num & (num-1)
    }
    return sum
}