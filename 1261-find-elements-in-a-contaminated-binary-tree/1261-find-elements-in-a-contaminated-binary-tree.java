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
    
    HashSet<Integer> set;
    
    
    public FindElements(TreeNode root) {
        this.root=root;
        this.set=new HashSet<>();
        
        recoverTree(root,0);
    }
    
    public void recoverTree(TreeNode root,int val){
        
        if(root==null)
        {
            return;
        }
        
        root.val=val;
        set.add(root.val);
        recoverTree(root.left,2*val+1);
        recoverTree(root.right,2*val+2);
        
    }
    
    public boolean find(int target) {
        return this.set.contains(target);
    }
    
//     public boolean findTarget(TreeNode root,int target)
//     {
//         if(root==null)
//         {
//             return false;
//         }
        
//         if(root.val==target)
//         {
//             return true;
//         }
        
//         return findTarget(root.left,target)||findTarget(root.right,target);
        
//     }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */