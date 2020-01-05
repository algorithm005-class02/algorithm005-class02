func lemonadeChange(bills []int) bool {
    if bills[0] != 5 {
        return false
    }
    fiveDollars := 0
    tenDollars := 0
    for _, money := range bills {
        if money == 5 {
            fiveDollars++
        } else if money == 10 {
            tenDollars++
            fiveDollars--
            if fiveDollars < 0 {
                return false
            }
        } else {
            if tenDollars > 0 {
                tenDollars--
                fiveDollars--
            } else {
                fiveDollars -= 3
            }
            if fiveDollars < 0 || tenDollars < 0 {
                return false
            }
        }
    }
    return true
}