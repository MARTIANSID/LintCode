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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        List<Integer> tree1=new ArrayList<>();
        List<Integer> tree2=new ArrayList<>();
        
        getLeafs(root1,tree1);
        getLeafs(root2,tree2);
        
        for(int i=0;i<Math.max(tree1.size(),tree2.size());i++){
            if(i >= tree1.size() || i >= tree2.size() || tree1.get(i)!=tree2.get(i))return false;
        }
        
        return true;
    }
    
    public void getLeafs(TreeNode root,List<Integer> nodes){
        if(root == null)return;
        
        if(root.left == null && root.right == null){
            nodes.add(root.val);
        }
        
        getLeafs(root.left,nodes);
        getLeafs(root.right,nodes);
    }
}