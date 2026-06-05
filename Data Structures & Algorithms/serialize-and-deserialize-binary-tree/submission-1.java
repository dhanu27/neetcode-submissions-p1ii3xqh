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

public class Codec {
    // public String serialize1(TreeNode root) {
    //     if(root)
    //    return "#"+ root.val + "L" + serialize1(root.left) + "L" + "R" +  serialize1(root.right) +
    //    "R"
    // }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        String result = "";
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode tmp = que.remove();
                if (tmp == null) {
                    result = result + "#null";
                    continue;
                } else {
                    result = result + "#" + tmp.val;
                }
                que.add(tmp.left);
                que.add(tmp.right);
            }
        }
        return result;
    }

    int getNode(String data, int indx[]) {
        int i = indx[0];
        // System.out.println("indx value:-" + indx[0] + " to process "+ data.substring(indx[0]));
        while (data.charAt(i) == '#') {
            i++;
        }
        int st = i;
        while (i < data.length() && data.charAt(i) != '#') {
            i++;
        }
        indx[0] = i;
        if (data.substring(st, i).equals("null")) {
            return Integer.MIN_VALUE;
        } else {
            // System.out.println("Node value:-" + data.substring(st, i));
            return Integer.parseInt(data.substring(st, i));
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> que = new LinkedList<>();
        // System.out.println("data value:-" + data);
        int indx[] = new int[1];
        int firstNode = getNode(data, indx);
        if (firstNode == Integer.MIN_VALUE) {
            return null;
        }
        TreeNode node = new TreeNode(firstNode);
        que.add(node);
        while (!que.isEmpty()) {
            TreeNode root = que.remove();
            int leftNode = getNode(data, indx);
            TreeNode lnode = null, rnode = null;
            if (leftNode != Integer.MIN_VALUE) {
                lnode = new TreeNode(leftNode);
            }

            int rightNode = getNode(data, indx);
            if (rightNode != Integer.MIN_VALUE) {
                rnode = new TreeNode(rightNode);
            }
            root.left = lnode;
            root.right = rnode;
            if (lnode != null) {
                que.add(lnode);
            }
            if (rnode != null) {
                que.add(rnode);
            }
        }
        return node;
    }
}
