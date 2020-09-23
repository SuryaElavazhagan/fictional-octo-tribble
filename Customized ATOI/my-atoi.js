/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function (str) {
  let num = '';
  let MIN_INT = -2147483648;
  let MAX_INT = Math.abs(MIN_INT);

  for (let i = 0; i < str.length; i++) {
    if (str[i] === ' ') {
      if (num === '') {
        continue;
      } else {
        break;
      }
    } else if ((str[i] === '-' || str[i] === '+') && num === '') {
      num += str[i];
    } else if (str[i] === '0' || !isNaN(str[i])) {
      num += str[i];
    } else {
      break;
    }
  }

  num = Number(num);

  if (isNaN(num)) {
    return 0;
  } else if (num < 0 && num <= MIN_INT) {
    return MIN_INT;
  } else if (num > 0 && num >= MAX_INT) {
    return MAX_INT - 1;
  } else {
    return num;
  }
};