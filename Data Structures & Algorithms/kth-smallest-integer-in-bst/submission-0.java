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
    public int kthSmallestHelper(TreeNode root, int k, int curr[]) {
        if (root == null) {
            return -1;
        }
        int leftAns = kthSmallestHelper(root.left, k, curr);
        if (leftAns > 0) {
            return leftAns;
        }
        curr[0]++;
        if (curr[0] == k) {
            return root.val;
        }
        int rightAns = kthSmallestHelper(root.right, k, curr);
        if (rightAns > 0) {
            return rightAns;
        }
        return -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] curr = new int[1];
        return kthSmallestHelper(root, k, curr);
    }
}
