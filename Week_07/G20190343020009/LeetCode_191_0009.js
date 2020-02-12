// 暴力法 转化成字符串 统计1的个数 
// 个人偏好正则 
var hammingWeight = function (n) {
  let result = n.toString(2).match(/(1)/g) || []
  return result.length
}