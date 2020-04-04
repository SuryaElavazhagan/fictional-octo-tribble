/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
  let result = false;
  let grids = [
      [
          new Set(),
          new Set(),
          new Set()
      ],
      [
          new Set(),
          new Set(),
          new Set()
      ],
      [
          new Set(),
          new Set(),
          new Set()
      ]
  ];
  let row = new Set();
  let column = new Set();

  for (let i = 0; i < 9; i++) {
      for (let j = 0; j < 9; j++) {
          let rowVal = +board[i][j];
          let colVal = +board[j][i];
          
          if (rowVal < 10 && !isNaN(rowVal)) {
              if (row.has(rowVal)) {
                  console.log('Row Value: ',i,j, rowVal);
                  return false;
              } else {
                  row.add(rowVal);
              }
              
              let computedI = Math.floor(i/3);
              let computedJ = Math.floor(j/3);
              if (grids[computedI][computedJ].has(rowVal)) {
                  console.log('Issue in i===j');
                  return false;
              } else {
                  grids[computedI][computedJ].add(rowVal);
              }
          }
          
          if (colVal < 10 && !isNaN(colVal)) {
              if (column.has(colVal)) {
                  console.log('Col Value: ',i,j, colVal);
                  return false;
              } else {
                  column.add(colVal);
              }
          }
      }
      row.clear();
      column.clear();
  }
  
  return true;
};