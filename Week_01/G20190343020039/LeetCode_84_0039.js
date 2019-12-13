/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
  var peek = function(stack) { return stack[stack.length - 1]; };
  let stack = [-1];
  let maxarea = 0;
  for (let i = 0; i < heights.length; i += 1) {
    while (peek(stack) !== -1 && heights[i] <= heights[peek(stack)]) {
      const top = stack.pop();
      const curarea = heights[top] * (i - peek(stack) - 1);
      maxarea = Math.max(maxarea, curarea)
    }
    stack.push(i);
  }
  while (peek(stack) !== -1) {
    const top = stack.pop();
    const curarea = heights[top] * (heights.length - peek(stack) - 1);
    maxarea = Math.max(maxarea, curarea)
  }
  return maxarea;
};
