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
class FindElements {
    
    TreeNode root;
    
    
    public FindElements(TreeNode root) {
        this.root=root;
        
        recoverTree(root,0);
    }
    
    public void recoverTree(TreeNode root,int val){
        
        if(root==null)
        {
            return;
        }
        
        root.val=val;
        recoverTree(root.left,2*val+1);
        recoverTree(root.right,2*val+2);
        
    }
    
    public boolean find(int target) {
        return findTarget(this.root,target);
    }
    
    public boolean findTarget(TreeNode root,int target)
    {
        if(root==null)
        {
            return false;
        }
        
        if(root.val==target)
        {
            return true;
        }
        
        return findTarget(root.left,target)||findTarget(root.right,target);
        
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */