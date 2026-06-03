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

    TreeNode buildTreeHelper(int[] preorder, int[] inorder, int lp, int rp, int lin, int rin, HashMap<Integer,Integer> map){
        if(rp < lp || lp <0 || rp >= preorder.length){
              return null;
        }

        int x = map.get(preorder[lp]);
        int numOfLeftSubTreeElements = x - lin;
        int numOfRightSubTreeElements = rin - x;
        TreeNode leftNode = buildTreeHelper(preorder, inorder, lp+1, lp + numOfLeftSubTreeElements, lin, lin+x-1, map);
        TreeNode rightNode = buildTreeHelper(preorder, inorder,lp + numOfLeftSubTreeElements + 1, rp, x + 1, rin, map);
        TreeNode newNode = new TreeNode(preorder[lp]);
        newNode.left = leftNode;
        newNode.right = rightNode; 
        return newNode;
    }



    public TreeNode buildTree(int[] preorder, int[] inorder) {
         int n = inorder.length;
         int m = preorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(inorder[i] , i);
        }
        return buildTreeHelper(preorder, inorder, 0, n-1, 0, m-1, map);
    }
}
