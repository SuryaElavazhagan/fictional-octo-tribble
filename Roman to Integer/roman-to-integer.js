/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
  /*
      Runtime: 164 ms, faster than 16.27% of JavaScript online submissions for Roman to Integer.
Memory Usage: 42 MB, less than 6.38% of JavaScript online submissions for Roman to Integer.
  */
  let result = 0;
  for (let i = 0, j = 1; i < s.length; i++, j++) {
      if (map.get(s[i]) < map.get(s[j])) {
          result += map.get(s[j++]) - map.get(s[i++]);
      } else {
          result += map.get(s[i]);
      }
  }
  const map = new Map([
      ['I', 1],
      ['V', 5],
      ['X', 10],
      ['L', 50],
      ['C', 100],
      ['D', 500],
      ['M', 1000],
      [undefined, 0]
  ]);
  return result;
};