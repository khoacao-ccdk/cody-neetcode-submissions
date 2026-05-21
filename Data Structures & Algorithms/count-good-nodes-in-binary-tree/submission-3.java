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
  private int goodCount;
  public int goodNodes(TreeNode root) {
    goodCount = 0;
    traverse(root, root.val);

    return goodCount;
  }

  private void traverse(TreeNode root, int maxValSeen) {
    if (root == null)
      return;

    if (root.val >= maxValSeen)
      goodCount++;

    int maxVal = Math.max(maxValSeen, root.val);

    traverse(root.left, maxVal);
    traverse(root.right, maxVal);
  }
}
