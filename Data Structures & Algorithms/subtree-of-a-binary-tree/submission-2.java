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
    //    1|2|4#5#3
    //    2|4#5
    //    2|4|5

        public boolean zfunction(String txt, String pattern) {
        String text = pattern + "$" + txt;
        int n = text.length();
        int z[] = new int[n];
        int l = 0, r = 0;
        System.out.println("Text:- "+text);
        for (int i = 1; i < n; i++) {
            if (i < r) {
                z[i] = Math.min(z[i - l], r - i+1);
            }
            while ((i + z[i]) < n && text.charAt(z[i]) == text.charAt(i + z[i])) {
                // System.out.println("while i:- "+i +"text.charAt(i) "+ text.charAt(i) + );
                z[i] = z[i] + 1;
            }

            if (z[i] + i - 1 > r) {
                l = i;
                r = z[i] + i - 1;
            }
            System.out.println("i:- "+i +"z[i] "+z[i]);
            if (z[i] == pattern.length()) {
                return true;
            }
        }
        return false;
    }

    public String convertTreeToString(TreeNode root){
        if(root == null){
            return "#";
        }
        return "@" + root.val + convertTreeToString(root.left) + convertTreeToString(root.right);
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if ((root == null && subRoot == null))
            return true;
        String matcher = convertTreeToString(root);  
        String pattern = convertTreeToString(subRoot);
        System.out.println(" Matcher" + matcher + "pattern :- " + pattern); 
        return zfunction(matcher, pattern);
    }
}
