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

    //0->count,1->sum,2->number of nodes

    public int averageOfSubtree(TreeNode root) {
        return solve(root)[0];
    }

    public int[] solve(TreeNode root) {
        if (root == null) return new int[3];

        int[] left = solve(root.left);
        int[] right = solve(root.right);
        int[] result = new int[3];
        result[0] = left[0] + right[0];
        result[1] = left[1] + right[1] + root.val;
        result[2] = left[2] + right[2] + 1;

       
        double avg = (double)((double)(result[1]) / (double)(result[2]));
        double rounded=(double)Math.round(avg * 100000d) / 100000d;

        
        if ((int)rounded == root.val) {
            result[0]++;
        }
        return result;
    }
}
