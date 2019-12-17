/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    if(height.length < 2) return 0;
    var max = 0;
    var i = 0,j = height.length - 1;
    while (i<j){
        var heightL = height[j] > height[i] ? height[i] : height[j];
        var area = heightL * (j-i);
        max = max > area ? max : area;
        height[j] > height[i] ? i++ : j--;
    }
    return max;
};