func firstUniqChar(s string) int {
    hashMap := make(map[byte]int)
    for i := 0; i < len(s); i++ {
        if v, ok := hashMap[s[i]]; ok{
            hashMap[s[i]] = v + 1
        }else{
            hashMap[s[i]] = 1
        }
    }
    for i := 0; i < len(s); i++ {
        if hashMap[s[i]] == 1 {
            return i
        }
    }
    return -1
}