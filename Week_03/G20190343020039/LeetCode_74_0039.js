/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
  let rows = matrix.length;
  if (rows === 0) { return false; }
  let cols = matrix[0].length;
  let left = 0;
  let right = rows * cols - 1;
  while (left <= right) {
    let mid = left + Math.floor((right - left) / 2);
    let midRow = Math.floor(mid / cols);
    let midCol = mid % cols;
    if (matrix[midRow][midCol] === target) {
      return true;
    } else if (matrix[midRow][midCol] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return false;
};
