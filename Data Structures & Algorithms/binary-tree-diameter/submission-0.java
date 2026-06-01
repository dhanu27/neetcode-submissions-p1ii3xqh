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
    
    public int heightOfBinaryTree(TreeNode root, int[]ans){
        if(root == null){
            return 0;
        }

        int leftHeight = heightOfBinaryTree(root.left, ans);
        int rightHeight = heightOfBinaryTree(root.right, ans);
        int height = 1 + Math.max(leftHeight, rightHeight);
        ans[0] = Math.max(ans[0], leftHeight + rightHeight);
        return height;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans= new int[1];
         heightOfBinaryTree(root,ans);
         return ans[0];
    }
}
