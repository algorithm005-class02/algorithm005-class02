func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }
    var S, T [26]int32
    for _, v := range s {
        S[v - 'a']++
    }
    for _, v := range t {
        T[v - 'a']--
    }
    
    for i := 0; i < len(S); i++ {
        if S[i] + T[i] != 0 {
            return false
        }
    }
    return true
}