/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    if(k>n || k==0){
        return []
    }else if(k==1){
        var retList = []
        for(var i=1;i<=n;++i){
            retList.push([i])
        }
        return retList
    }else if (k==n){
        var retList = []
        for(var i=1;i<=n;++i){
            retList.push(i)
        }
        return [retList]
    }


    var retList = combine(n-1,k)
    var tempList = combine(n-1,k-1);
    for(var i=0;i<tempList.length;++i){
        var list = tempList[i]
        list.push(n)
        retList.push(list)
    }
    return retList;
};