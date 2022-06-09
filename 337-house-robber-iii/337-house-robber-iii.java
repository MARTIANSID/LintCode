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

//0>rob
//1->not rob
class Solution {

    public int rob(TreeNode root) {
        int[] arr = solve(root);
        return Math.max(arr[0], arr[1]);
    }

    public int[] solve(TreeNode root) {
        if (root == null) return new int[] { 0, 0 };

        int rob = 0, notRob = 0;

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        rob = (left[1] + right[1] + root.val);
        notRob = (Math.max(left[0], left[1]) + Math.max(right[0], right[1]));

        return new int[] { rob, notRob };
    }
}
