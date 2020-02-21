func groupAnagrams(strs []string) [][]string {
    var result [][]string
    mark := make(map[[26]byte]int)

    for _, str := range strs {
        var tmp [26]byte
        for _, ch := range str {
            tmp[ch - 'a']++
        }

        i, ok := mark[tmp]
        if ok {
            result[i] = append(result[i], str)
        } else {
            mark[tmp] = len(mark)
            result = append(result, []string{str})
        }
    }

    return result
}