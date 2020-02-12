var relativeSortArray = function (arr1, arr2) {
  let map = new Map(),
    arr2Copy = [];
  for (let i = 0, len = arr2.length; i < len; i++) {
    arr2Copy.push(arr2[i]);
    map.set(arr2[i], 1);
  }

  for (let i = 0, len = arr1.length; i < len; i++) {
    let inArr2Index = arr2Copy.indexOf(arr1[i]);
    if (inArr2Index > -1) {
      if (map.has(arr1[i])) {
        map.delete(arr1[i]);
      } else {
        arr2.splice(inArr2Index, 0, arr1[i]);
      }
      arr1.splice(i, 1);
      i--;
    }
  }

  arr1.sort((a, b) => a - b);

  return [...arr2, ...arr1];
};