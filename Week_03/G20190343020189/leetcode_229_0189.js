// 229. Majority Element II
/** Explanation from the highest voted discussion:
 *  Boyer-Moore Majority Vote algorithm (http://goo.gl/64Nams)
 *  essential concepts: 
 *  - keep a counter for the majority number X. 
 *  - If you find a number Y that is not X, the current counter should deduce 1. 
 *  - The reason is that if there is 5 X and 4 Y, there would be one (5-4) more X than Y. 
 *  - This could be explained as "4 X being paired out by 4 Y".
 * 
 *  And since the requirement is finding the majority for more than ceiling of [n/3], 
 *  the answer would be less than or equal to two numbers.
 *  So we can modify the algorithm to maintain two counters for two majorities.
 */

 
/** my first attempt
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function(nums) {
  if (!nums || !nums.length) return [];

  // init two candidates & corresponding counts
  let num1,
    num2,
    count1 = 0,
    count2 = 0;
  for (let num of nums) {
    // update candidate assignment
    if (num !== num2 && count1 === 0) {
      num1 = num;
    }
    if (num !== num1 && count2 === 0) {
      num2 = num;
    }

    // update count
    if (num1 === num) {
      count1++;
    } else if (num !== num2 && count1 > 0) {
      // only reduce count if num is not a candidate
      count1--;
    }

    if (num2 === num) {
      count2++;
    } else if (num !== num1 && count2 > 0) {
      count2--;
    }
  }

  let results = [];
  count1 = getCount(nums, num1);
  count2 = getCount(nums, num2);

  // verify candidates
  if (count1 > nums.length / 3) results.push(num1);
  if (count2 > nums.length / 3) results.push(num2);

  return results;

  function getCount(nums, target) {
    if (target === undefined) return 0;
    let count = 0;
    for (let num of nums) {
      if (num === target) {
        count++;
      }
    }

    return count;
  }
};

// better solution
var majorityElement = function(nums) {
  if (!nums || !nums.length) return [];
  
  // init two candidates & corresponding counts
  let num1, num2, count1 = 0, count2 = 0;

  // loop
  for (let num of nums) {
      if (num === num1) {
          count1++;
      } else if (num === num2) {
          count2++;
      } else if (count1 === 0) {
          num1 = num;
          count1 = 1;
      } else if (count2 === 0) {
          num2 = num;
          count2 = 1;
      } else { // reduce only when num is not both candidates
          count1--;
          count2--;
      }
  }
      
  let results = [];
  
  // verify candidates
  if (getCount(nums, num1) > nums.length / 3) results.push(num1);
  if (getCount(nums, num2) > nums.length / 3) results.push(num2);
  
  return results;
  
  
  function getCount(nums, target) {
      if (target === undefined) return 0;
      let count = 0;
      for (let num of nums) {
          if (num === target) {
              count++;
          }
      }
      
      return count;
  }
};  

// brilliant & intuitive python solution
// https://leetcode.com/problems/majority-element-ii/discuss/63502/6-lines-general-case-O(N)-time-and-O(k)-space
/**
 * class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        ctr = collections.Counter()
        for num in nums:
            ctr[num] += 1
            if len(ctr) == 3:
                ctr -= collections.Counter(set(ctr))

        return [n for n in ctr if nums.count(n) > len(nums) / 3]
 */