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
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> que=new LinkedList<>();
        
        que.add(root);
        int level=1,max=-(int)1e9,ans=1;
        
        while(que.size()!=0){
            int size=que.size(),sum=0;
            
            while(size-->0){
                TreeNode node=que.removeFirst();
                sum+=node.val;
                if(node.right!=null)que.add(node.right);
                if(node.left!=null)que.add(node.left);
            }
            if(sum > max){
                ans=level;
                max=sum;
            }
            level++;
        }
        return ans;
    }
}