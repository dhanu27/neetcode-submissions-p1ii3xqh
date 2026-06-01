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

    public int isBalancedHeight(TreeNode root){
        if(root == null)
          return 0;

        int leftHeight = isBalancedHeight(root.left);
        int rightHeight = isBalancedHeight(root.right);
         boolean isNotBalanced = Math.abs(rightHeight - leftHeight) > 1;
        if(leftHeight < 0 || rightHeight < 0 || isNotBalanced){
            return -1;
        }
        return Math.max(leftHeight , rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        int balance = isBalancedHeight(root);
        return balance < 0 ? false : true;
    }
}
