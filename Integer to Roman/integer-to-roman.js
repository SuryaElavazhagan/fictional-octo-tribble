/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    /**
        Runtime: 104 ms, faster than 99.93% of JavaScript online submissions for Integer to Roman.
        Memory Usage: 40.7 MB, less than 60.00% of JavaScript online submissions for Integer to Roman.
        **/
    let romans = [['I', 'V'], ['X', 'L'], ['C', 'D'], ['M']]
    let result = '';
    let iterator = 0;
    while (num > 0) {
        const current = num % 10;
        if (current === 1 || current === 5) {
            result = `${romans[iterator][current === 1 ? 0 : 1]}${result}`;
        } else if (current === 4 || current === 9) {
            result = `${current === 4 ? romans[iterator].join('') : `${romans[iterator][0]}${romans[iterator + 1][0]}`}${result}`;
        } else if (current !== 0) {
            result = `${romans[iterator][0].repeat(current - (current < 5 ? 1 : 5))}${result}`;
            result = `${romans[iterator][current < 5 ? 0 : 1]}${result}`;
        }
        
        num = Math.floor(num / 10);
        iterator++;
    }
    
    return result;
};