/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
  private int maxDiameter;
  public int diameterOfBinaryTree(TreeNode root) {
    maxDiameter = 0;
    traverse(root);
    return maxDiameter;
  }

  private void traverse(TreeNode root) {
    if(root == null) return;

    int diameter = height(root.left) + height(root.right);

    maxDiameter = Math.max(diameter, maxDiameter);

    traverse(root.left);
    traverse(root.right);
  }

  private int height(TreeNode root) {
    if(root == null) return 0;

    return 1 + Math.max(height(root.left), height(root.right));
  }
}
