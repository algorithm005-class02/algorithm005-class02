// 旋转数组 
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
    var actualK = k % nums.length
    if (actualK === 0) return
    var tempArr = []
    for (var index = 0; index < nums.length; index++) {
        if (index + actualK > nums.length - 1) {
            swap(nums, index, index + actualK - nums.length)
        } else {
            tempArr.push(nums[index])
        }
    }
    for (let index = 0; index < tempArr.length; index++) {
        nums[index + actualK] = tempArr[index]

    }
}

function swap(array, i, j) {
    var temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

var nums = [1, 2]
rotate(nums, 3)
console.log(nums)


