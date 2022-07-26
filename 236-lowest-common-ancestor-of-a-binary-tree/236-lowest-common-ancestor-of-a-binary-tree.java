/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (root == p || root == q) return root;

        if (left != null && right != null) return root; else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
