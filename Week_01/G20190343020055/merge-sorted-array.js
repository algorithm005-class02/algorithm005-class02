/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    
    let arr = (nums1.slice(0,m)).concat(nums2)
    
    arr.sort((x, y) => {

        if (x < y) {
            return -1
        } else if (x > y) {
            return 1
        } 
        return 0
    })
    for (let i = 0; i < arr.length; i++) {
        nums1[i] = arr[i]
    }
};