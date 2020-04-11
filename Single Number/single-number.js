/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
  let a = 0;
  /**
      Runtime: 56 ms, faster than 83.87% of JavaScript online submissions for Single Number.
Memory Usage: 35.5 MB, less than 76.92% of JavaScript online submissions for Single Number.
  **/
  for (let i = 0; i < nums.length; i++) {
      a ^= nums[i];
  }
  
  return a;
};