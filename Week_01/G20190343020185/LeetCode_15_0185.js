
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum1 = function(nums) {
    nums.sort((function(a,b){return a-b}));
    var res = [],d=[],tmp = 9999;
    console.log(nums)
    for(var i =  0; i< nums.length;i++){
        if(nums[i]>0) break;
        if(tmp == nums[i]) continue;
        tmp = nums[i];
        var j=i+1,k=nums.length-1;
        while(j<k){
            var tmpsum = nums[i] + nums[j]+nums[k];
            var tmpleft = nums[j],tmpright=nums[k];
            if(tmpsum < 0) j++;
            else if(tmpsum > 0) k--;
            else{
                d.push(nums[i],nums[j],nums[k]);
                res.push(d);
                d=[];
                while(nums[j]-tmpleft == 0) j++;
                while(nums[k]-tmpright == 0) k--;
            }
        }
    }
    return res;
};


export default threeSum1;