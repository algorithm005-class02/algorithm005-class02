var firstUniqChar = function (s) {
  let m = new Map();
  for (let i = 0; i < s.length; i++) {
    if (m.has(s[i])) {
      m.set(s[i], -1);
    } else {
      m.set(s[i], i);
    }

  }

  for (let i = 0; i < s.length; i++) {
    let v = m.get(s[i]);
    if (v != -1)
      return i;
  }
  return -1;
}