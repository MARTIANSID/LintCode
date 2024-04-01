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

    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();

        que.add(root);

        while (que.size() > 0) {
            int size = que.size();

            while (size-- > 0) {
                TreeNode node = que.removeFirst(); // O(1)

                if (node == null) continue;

                que.add(node.left);
                que.add(node.right);
            }

            for (int i = 0; i < que.size() / 2; i++) {
                TreeNode start = que.get(i);

                TreeNode end = que.get(que.size() - i - 1);

                if (start == null && end != null) return false;

                if (end == null && start != null) return false;

                if (start != null && end != null) {
                    
                    if(start.val != end.val)return false;
                }
            }
        }
        return true;
    }
}
