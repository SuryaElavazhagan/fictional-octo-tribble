/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    /**
    Runtime: 80 ms, faster than 38.38% of JavaScript online submissions for Reverse Integer.
    Memory Usage: 35.5 MB, less than 95.83% of JavaScript online submissions for Reverse Integer.
    **/
   //  let result = 0;
   //  let i = x < 0 ? (x * -1) : x;
   //  let carry = 0;
   //  while (i > 0) {
   //      carry = i % 10;
   //      i = Math.floor(i / 10);
   //      result = (result * 10) + carry;
   // }
   // if (result > Math.pow(2, 31)) {
   //     return 0;
   // }
   // return x < 0 ? (result * -1) : result;
    
    /**
        Runtime: 72 ms, faster than 78.35% of JavaScript online submissions for Reverse Integer.
Memory Usage: 35.9 MB, less than 42.71% of JavaScript online submissions for Reverse Integer.   
    **/
    const result = `${Math.abs(x)}`.split('').reverse().join('');
    if (+result > Math.pow(2, 31)) {
        return 0;
    }
    
    return x < 0 ? -(+result) : +result;
};