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


    public TreeNode invertTree(TreeNode root) {
        if(root == null)
          return root;
        TreeNode rightNode =  invertTree(root.left);
        TreeNode leftNode = invertTree(root.right);
        root.right = rightNode;
        root.left = leftNode;   
        return root;
    }
}
