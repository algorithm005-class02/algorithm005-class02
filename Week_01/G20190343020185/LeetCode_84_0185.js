/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    if(heights.length == 0) return 0;
    var max = heights[0];
    for(var i = 0;i<heights.length;i++){
        var s =  0; t =0;
        for(var j = i;j>=0;j--){
            if(heights[j] < heights[i]){
                break;
            }
            s=j;
        }
        for(var j = i;j<heights.length;j++){
            if(heights[j] < heights[i]){
                break;
            }
            t=j;
        }
        max = max>heights[i]*(t-s+1)?max:heights[i]*(t-s+1);
    }
    return max;
};

export default largestRectangleArea;