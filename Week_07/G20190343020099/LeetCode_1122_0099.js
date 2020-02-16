/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
  let count = 0;
  for (let i = 0; i < arr2.length; i++) {
      let la1 = arr1.length;
      let j = count;
      for (; j <la1; j++) {
          if (arr1[j] == arr2[i]) {
              [arr1[j], arr1[count]] = [arr1[count], arr1[j]]
              count++;
          }
      }
  }
  let temp = arr1.slice(count).sort((a, b) => a - b);
  for (let k = 0; k < temp.length; k++) arr1[count + k] = temp[k]
  return arr1;
};