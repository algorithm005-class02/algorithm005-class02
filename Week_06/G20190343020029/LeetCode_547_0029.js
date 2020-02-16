/*
 * @lc app=leetcode.cn id=547 lang=javascript
 *
 * [547] 朋友圈
 */

// @lc code=start
/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function(M) {
    let N = M.length
    let arr = new Array()
    for (let i = 0; i < N; i++) {
        arr[i] = new Set()
        for (let j = i+1; j < N; j++) {
            if(M[i][j] == 1) {
                arr[i].add(i).add(j)
            }
        }
    }
    let num = 0
    let nums1 = 0

    function getUnion(arr) {
        let len = arr.length
        let arr1 = []
        num = 0
        nums1 = 0
        for (let i = 0; i < len; i++) {
            if(!arr[i].marked) {
                let res1 = new Set(arr[i])
                arr[i].marked = true
                let j = i
                while(j < len) {
                    if(check(arr[i], arr[j]).size > 0) {
                        arr[j].marked = true
                        res1 = new Set([...res1, ...arr[j]]);
                    }
                    j++
                }
                if(res1.size > 0) {
                    num++
                    arr1.push(res1)
                    nums1 += res1.size
                }
            }
        }
        if (arr1.length != arr.length) {
            return getUnion(arr1)
        } else {
            return arr1
        }
    }
    return N - nums1 + num
};
//比较两个参数有无重合
function check(param1, param2) {
    let intersect = new Set([...param1].filter(x => param2.has(x)));
    return intersect
}
// @lc code=end

