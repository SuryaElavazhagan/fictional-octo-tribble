/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
  let num2Map = new Map();
  nums2.forEach(value => {
      let count = num2Map.get(value) || 0;
      num2Map.set(value, count + 1);
  });
  
  let result = nums1.filter((value) => {
      let count = num2Map.get(value) || 0;
      if (count > 0) {
          num2Map.set(value,count - 1);
          return true;
      }
      return false;
  });
  
  return result;
};