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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> subList = new ArrayList<Integer>();

            while (size-- > 0) {
                TreeNode lastNode = que.remove();
                subList.add(lastNode.val);
                if (lastNode.left != null) {
                    que.add(lastNode.left);
                }
                if (lastNode.right != null) {
                    que.add(lastNode.right);
                }
            }
            ans.add(subList);
        }
        return ans;
    }
}
