/*
 * @lc app=leetcode.cn id=11 lang=javascript
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let area = 0;
    for(let i = 0; i < height.length; i++) {
        for(let j = i + 1; j<height.length; j++) {
            let high = height[i] > height[j] ? height[j] : height[i]
            let area1 = (j - i) * high
            if(area < area1) {
                area = area1 
            }
        }
    }
    return area
};
// @lc code=end

