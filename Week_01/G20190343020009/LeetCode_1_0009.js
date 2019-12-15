// 两数之和
// 第一版 小优化 两层for循环 时间复杂度nlogn
const twoSum = function (nums, target) {
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return [i,j]
            }
        }
    }
    return []
}
// 第二版 如何变单循环 map
// 直接map.has就不用第二层循环了
// 从循环查找 变成哈希查找 这应该算空间换时间
// 能过 但是有问题 map的key不能重复，map.has只能找key
const twoSum = function (nums, target) {
    let amap = new Map()
    // 先来一个循环？
    for (let i = 0; i < nums.length; i++) {
        amap.set(nums[i], i)
    }
    for (let i = 0; i < nums.length; i++) {
        // 不能找自己
        const wanted = target - nums[i]
        if (amap.has(wanted)) {
            if (i == amap.get(wanted)) {
                continue
            }
            return [i, amap.get(wanted)]
        }
    }
    return []
}

// 第三版 就是高票参考答案了
const twoSum = function(nums, target) {
    let amap = new Map()
    let wanted
    for (let i = 0; i < nums.length; i++) {
        wanted = target - nums[i]
        if (amap.has(wanted)) {
            return [amap.get(wanted), i]
        }
        amap.set(nums[i], i)
    }
    return []
}

