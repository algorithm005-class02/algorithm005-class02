/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length !== t.length) {
    return false;
  }

  const m = new Map();
  for (let i = 0; i < s.length; i += 1) {
    const c = s.charCodeAt(i);
    if (m.has(c)) {
      m.set(c, m.get(c) + 1);
    } else {
      m.set(c, 1);
    }
  }

  for (let i = 0; i < t.length; i += 1) {
    const c = t.charCodeAt(i);
    if (m.has(c)) {
      if (m.get(c) === 1) {
        m.delete(c);
      } else {
        m.set(c, m.get(c) - 1);
      }
    } else {
      return false;
    }
  }

  return m.size === 0;
};
