/**
 * @param {number[]} T
 * @return {number[]}
 */
var dailyTemperatures = function(temperatures) {
  let stack = [];
  let result = new Array(temperatures.length).fill(0);

  for (let i = 0; i < temperatures.length; i++) {
      for (let j = 0; j < stack.length; j++) {
          if (stack[j][0] < temperatures[i]) {
              result[stack[j][1]] = i - stack[j][1];
              stack.splice(j, 1);
              j--;
          }
      }
      
      if (i !== temperatures.length - 1) {
          if (temperatures[i] < temperatures[i + 1]) {
              result[i] = 1;
          } else {
              stack.push([temperatures[i], i]);
          }
      }
  }
  
  return result;
};