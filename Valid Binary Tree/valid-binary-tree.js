/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
  var result = [];
  var inOrder = function(node) {
      if (node === null) {
          return;
      }
      inOrder(node.left);
      result.push(node.val);
      inOrder(node.right);
  }
  
  // Left-Root-Right
  inOrder(root);
  
  for (let i = 1; i < result.length; i++) {
      if (result[i - 1] >= result[i]) {
          return false;
      }
  }
  
  return true;
};

