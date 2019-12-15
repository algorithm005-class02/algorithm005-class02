/*
 * @lc app=leetcode.cn id=84 lang=javascript
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    let maxarea = 0;
    let stackHeights = [-1];
    for(let index = 0;index < heights.length;index++){
        let height = heights[index];
        // 如果当前值小于等于栈顶的值 则栈顶出栈计算以栈顶为高宽度到当前位置的面积
        while (stackHeights.length > 1 && heights[stackHeights[stackHeights.length - 1]] >= height ) {
            let topIndex = stackHeights.pop();
            let secIndex = stackHeights[stackHeights.length - 1];
            maxarea = Math.max(maxarea, heights[topIndex] * (index - secIndex - 1));
        }
        stackHeights.push( index );
    };
    while ( stackHeights.length > 1 ) {
        let topIndex = stackHeights.pop();
        let secIndex = stackHeights[stackHeights.length - 1];
        maxarea = Math.max(maxarea, heights[topIndex] * (heights.length - secIndex - 1));
    }

    return maxarea;
};
// @lc code=end
largestRectangleArea([2,1,5,6,2,3])
