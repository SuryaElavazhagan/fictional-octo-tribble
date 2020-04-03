/**
 * @link https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let map = new Map();
    let i = 0;
    let j = 0;
    let ans = 0;
    
    while (j < s.length) {
        if (map.has(s[j])) {
            i = Math.max(map.get(s[j]), i);
        }
        ans = Math.max(ans, j - i + 1);
        map.set(s[j], j + 1);
        j++;
    }
    
    return ans;
};