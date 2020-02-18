/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
  if (!matrix || !matrix.length) return 0;
  let height = matrix[0];
  let max = 0;
  for (let i = 0; i < matrix.length; i++) {
      for (let j = 0; j < matrix[0].length; j++) {
          if (i === 0) break;
          if (matrix[i][j] === "1") {
              height[j] = Number(height[j]) + 1;
          } else {
              height[j] = 0;
          }
      }
      let rectangleArea = largestRectangleArea(height);
      max = Math.max(rectangleArea, max);
  }
  return max;
};

function largestRectangleArea(height) {
  let stack = [-1, 0];
  let max = 0;
  for (let i = 1; i < height.length; i++) {
      while (height[i] < height[stack[stack.length - 1]]) {
          let dimension = height[stack.pop()] * (i - stack[stack.length - 1] - 1);
          max = Math.max(max, dimension);
      }
      stack.push(i);
  }
  while (stack[stack.length - 1] !== -1) {
      let dimension = height[stack.pop()] * (height.length - stack[stack.length - 1] - 1);
      max = Math.max(max, dimension);
  }
  return max;
}