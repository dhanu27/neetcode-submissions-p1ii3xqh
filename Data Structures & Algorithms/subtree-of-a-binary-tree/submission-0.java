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
    
    public boolean checkIsSameTree(TreeNode root, TreeNode subRoot){
          if ((root == null && subRoot == null))
            return true;
        if (root == null || subRoot == null)
            return false;
        if (root.val != subRoot.val) {
          return false;
        }
        return checkIsSameTree(root.left, subRoot.left) && checkIsSameTree(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if ((root == null && subRoot == null))
            return true;
        if (root == null || subRoot == null)
            return false;
        if (root.val == subRoot.val) {
            boolean isSameTree = checkIsSameTree(root, subRoot);
            if (isSameTree) {
                return true;
            }
        }
        boolean foundInLeftSide = isSubtree(root.left, subRoot);
        if (foundInLeftSide) {
            return true;
        }
        boolean foundInRightSide = isSubtree(root.right, subRoot);
        return foundInRightSide;
    }
}
