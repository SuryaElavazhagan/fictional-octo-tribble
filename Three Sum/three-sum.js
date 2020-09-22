/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
  nums.sort((a, b) => a-b);
  let result = [];
  for (let i = 0; i < nums.length - 2; i++) {
      let j = i + 1;
      let k = nums.length - 1;
      
      if (i > 0 && nums[i] === nums[i - 1]) {
          continue;
      }
      
      while (j < k) {
          let threeSum = nums[i] + nums[j] + nums[k];
          if (threeSum === 0) {
              result.push([nums[i], nums[j], nums[k]]);
              do { j++; } while(j < k && nums[j] === nums[j - 1]);
              do { k--; } while(j < k && nums[k] === nums[k + 1]);
          } else if (threeSum > 0) {
              k--;
          } else {
              j++;
          }
      }
  }
  
  return result;
};