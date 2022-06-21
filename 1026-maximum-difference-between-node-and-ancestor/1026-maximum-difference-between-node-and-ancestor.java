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
    0->max
    1->min
    2->result
    
    logic - > difference for a particular node will maximum with either the max value or the min value in its sub tree
    
    */

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root)[2];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        if (left == null && right == null) return new int[] { root.val, root.val, 0 }; 
        else if (right == null) {
            right = left;
        } else if (left == null) {
            left = right;
        }

        int[] result = new int[3];

        result[0] = Math.max(left[0], Math.max(right[0], root.val));
        result[1] = Math.min(left[1], Math.min(right[1], root.val));
        result[2] = Math.max(Math.max(left[2], Math.abs(root.val - Math.max(left[0], right[0]))), Math.max(right[2],Math.abs(root.val - Math.min(left[1], right[1]))));

        return result;
    }
}
