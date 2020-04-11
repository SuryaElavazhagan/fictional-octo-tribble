/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
  /**
      Runtime: 192 ms, faster than 66.84% of JavaScript online submissions for Palindrome Number.
Memory Usage: 45 MB, less than 91.38% of JavaScript online submissions for Palindrome Number.
  **/
  // if (x < 0) {
  //     return false;
  // }
  // let result = 0;
  // let i = Math.abs(x);
  // while (i > 0) {
  //     result = (result * 10) + (i % 10);
  //     i = Math.floor(i / 10);
  // }
  // return result === x;
  
  /**
  Runtime: 200 ms, faster than 53.44% of JavaScript online submissions for Palindrome Number.
Memory Usage: 45.9 MB, less than 29.31% of JavaScript online submissions for Palindrome Number.
  **/
  return `${x}`.split('').reverse().join('') === `${x}`;
};