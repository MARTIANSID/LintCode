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
    /*
    -1->node needs camera
     1->node is camera
     0->node is covered by a camera
    */
    int count = 0;

    public int minCameraCover(TreeNode root) {
        int r = dfs(root);
        if (r == -1) count++;
        return count;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1) {
            count++;
            return 1;
        }
        if (left == 1 || right == 1) return 0;
        return -1;
    }
}
