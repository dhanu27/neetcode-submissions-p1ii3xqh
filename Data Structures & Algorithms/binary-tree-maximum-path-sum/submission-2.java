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
    int incl;
    int excl;
    Ans(int incl, int excl) {
        this.incl = incl;
        this.excl = excl;
    }
}
class Solution {
    public Ans maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return new Ans(-1000000, -1000000);
        }

        if (root.left == null && root.right == null) {
            return new Ans(root.val, root.val);
        }

        Ans leftAns = maxPathSumHelper(root.left);
        Ans rightAns = maxPathSumHelper(root.right);
        int tmp = (leftAns.incl == -1000000 && rightAns.incl == -1000000)
            ? -1000000
            : leftAns.incl + root.val + rightAns.incl;


        int excl = Math.max(leftAns.excl,
                            Math.max(rightAns.excl, 
                            Math.max(root.val, 
                            Math.max(rightAns.incl, 
                            Math.max(leftAns.incl, tmp
                            )))));
        
        int incl = Math.max(
            leftAns.incl + root.val, 
            Math.max(root.val, rightAns.incl + root.val));

        return new Ans(incl, excl);
    }

    public int maxPathSum(TreeNode root) {
        Ans result = maxPathSumHelper(root);
        return Math.max(result.excl, result.incl);
    }
}
