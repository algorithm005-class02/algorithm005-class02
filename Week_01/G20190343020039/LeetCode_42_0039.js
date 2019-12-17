/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  var peek = function(stack) { return stack[stack.length - 1]; }
  let result = 0;
  let stack = [];
  for (let i = 0; i < height.length; i += 1) {
    while (stack.length > 0 && height[i] > height[peek(stack)]) {
      const top = stack.pop();
      if (stack.length === 0) {
        break;
      }
      let width = i - peek(stack) - 1;
      let bounded_height = Math.min(height[i], height[peek(stack)]) - height[top];
      result += width * bounded_height;
    }
    stack.push(i);
  }
  return result;
};
