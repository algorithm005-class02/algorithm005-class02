func myPow(x float64, n int) float64 {
    if n==1{
        return x
    }
    if n<0{
        x=1/x
        n=-n
    }
    if n==0{
        return 1
    }

    a := myPow(x ,n/2)

    if n%2 == 1{
        return a*a*x
    }else{
        return a*a
    }
    
}