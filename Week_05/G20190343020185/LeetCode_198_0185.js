/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let sum1=0,sum2=0,sum3=0;
    nums.map((item,index)=>{
        let max = 0;
        max = sum1 > sum2 ? sum1 : sum2;
        max = item + max > sum3 ? item + max : sum3;
        sum1 = sum2;sum2 = sum3;sum3 = max;
    });
    var res = sum1 > sum2 ? sum1 : sum2;
    res = res > sum3 ? res : sum3;
    return res;
};

export default rob;
