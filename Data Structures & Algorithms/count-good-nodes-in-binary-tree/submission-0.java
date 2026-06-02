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
   
    public int goodNodeHelper(TreeNode root, int max){

        if(root==null){
            return 0;
        }
        int newMax = Math.max(max, root.val);
        int childAns = goodNodeHelper(root.left, newMax) + goodNodeHelper(root.right, newMax);
        if(root.val >= max){
            childAns++;
        }
       return childAns; 
    }

    public int goodNodes(TreeNode root) {
        return goodNodeHelper(root, Integer.MIN_VALUE);
    }
}
