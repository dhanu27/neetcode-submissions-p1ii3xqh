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

class Ans {
    int min;
    int max;
    boolean isValid;

    Ans(int min, int max, boolean isValid) {
        this.min = min;
        this.max = max;
        this.isValid = isValid;
    }
}

class Solution {
    public Ans isValidBSTHelper(TreeNode root) {
        if (root == null) {
            return new Ans(Integer.MAX_VALUE,Integer.MIN_VALUE, true);
        }
        if (root.left != null && root.left.val >= root.val) {
            return new Ans(-1, -1, false);
        }
        if (root.right != null && root.right.val <= root.val) {
            return new Ans(-1, -1, false);
        }
        if (root.left == null && root.right == null) {
            return new Ans(root.val, root.val, true);
        }
        
        Ans leftAns = isValidBSTHelper(root.left);
        if (!leftAns.isValid) {
            return leftAns;
        }

        Ans rightAns = isValidBSTHelper(root.right);
        if (!rightAns.isValid) {
            return rightAns;
        }
        // && (rightAns.max > root.val)
        if ((rightAns.min > root.val) && 
            (leftAns.max < root.val)) {
            return new Ans(leftAns.min, rightAns.max, true);
        }
        return new Ans(leftAns.min, rightAns.max, false);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBSTHelper(root).isValid;
    }
}
