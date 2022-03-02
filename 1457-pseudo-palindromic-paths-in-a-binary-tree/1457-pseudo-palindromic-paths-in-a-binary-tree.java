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

    public int pseudoPalindromicPaths(TreeNode root) {
        return solve(root, new int[10]);
    }

    public int solve(TreeNode root, int[] freq) {
        if (root == null) return 0;

        int count = 0,val=root.val;

        freq[val]++;

        if (root.left == null && root.right == null) {
            //leaf node

            int odds = 0;
            for (int ele : freq) {
                if ((ele & 1) != 0) {
                    //even
                    odds++;
                }

                if (odds >= 2) break;
            }

            if (odds < 2) count++;
        }

       

        count += solve(root.left, freq);
        count += solve(root.right, freq);

        freq[val]--;

        return count;
    }
}
