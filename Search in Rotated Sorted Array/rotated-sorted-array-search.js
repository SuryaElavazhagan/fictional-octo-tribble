/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  if (nums[0] === target) {
      return 0;
  }
  let isReversedSearch = nums[0] > target;
  let i = isReversedSearch ? (nums.length - 1) : 0;
  
  while (i > -1 && i < nums.length) {
      if (target === nums[i]) {
          return i;
      }
      
      i = isReversedSearch ? (i - 1) : (i + 1);
  }
  
  return -1;
};