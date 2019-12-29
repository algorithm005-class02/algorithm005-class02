var isAnagram = function (s, t) {
  // 核心就是一个判断嘛 充分且必要的判断是什么呢
  // 一 暴力法 看直观的外在表现就是排序后字符串一样了 对两个字符串排序 遍历对比 2nlogn + n
  // 时间15 空间7 也太辣鸡了
  if (s.length != t.length) {
    return false
  }
  // const arrS = Array.from(s)
  // arrS.sort()
  // const arrT = Array.from(t)
  // arrT.sort()
  // for (let i = 0; i < arrS.length; i++) {
  //   if (arrS[i] != arrT[i]) {
  //     return false
  //   }
  // }
  // return true
  // 二 细致一点  所有字符出现的次数都一样
  // 哈希表统计两个字符串的字符排列 弄一个map统计s所有字符的次数 然后用循环t的去减map 所有的值 都刚好为0就可以 3n
  // 时间52 空间8 我的天呐 还是很辣鸡啊
  const arrS = Array.from(s)
  const mapS = new Map()
  for (let i = 0; i < arrS.length; i++) {
    let char = arrS[i]
    let times = mapS.get(char)
    if (times) {
      mapS.set(char, times + 1)
    } else {
      mapS.set(char, 1)
    }
  }
  const arrT = Array.from(t)
  const mapT = new Map()
  for (let i = 0; i < arrT.length; i++) {
    let char = arrT[i]
    let times = mapT.get(char)
    if (times) {
      mapT.set(char, times + 1)
    } else {
      mapT.set(char, 1)
    }
  }
  let result = true
  mapS.forEach((value, key) => {
    if (mapT.get(key) != value) {
      result = false
      return false
    }
  })
  return result
};