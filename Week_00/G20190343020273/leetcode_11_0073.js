var maxArea = function (height) {
    var maxArea = 0
    for (var i = 0, j = height.length - 1; i < j;) {
        var minHeight = Math.min(height[i], height[j])
        var area = minHeight * (j - i )
        maxArea = Math.max(maxArea, area)
        if (height[i] < height[j]) {
            i++
        } else {
            j--
        }
    }
    return maxArea

};

var height = [1, 8, 6, 2, 5, 4, 8, 3, 7]

var res = maxArea(height)
console.log("res", res)