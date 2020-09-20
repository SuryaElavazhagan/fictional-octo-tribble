/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
  var resultNums = [];
  var lengthSum = nums1.length + nums2.length;
  var medianPosition = lengthSum % 2 === 0 ? ((lengthSum / 2) - 1) : Math.floor(lengthSum / 2);
  var median = NaN;
  for (let i = 0, j = 0; i < nums1.length || j < nums2.length;) {
      if (i >= nums1.length) {
        resultNums.push(nums2[j++]);
      } else if (j >= nums2.length) {
        resultNums.push(nums1[i++]);
      } else {
        resultNums.push(nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++]);
      }
      let lastIndex = resultNums.length - 1;
      if (medianPosition === lastIndex) {
        if (isNaN(median)) {
          median = resultNums[lastIndex];
          if (lengthSum % 2 === 0) {
            medianPosition += 1;
          } else {
            return median;
          }
        } else {
          median = (median + resultNums[lastIndex]) / 2;
          return median;
        }
      }
  }
};