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
class CBTInserter {
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root=root;
    }
    
    public int insert(int val) {
        LinkedList<TreeNode> que=new LinkedList<>();
        que.add(root);
        
        while(que.size()!=0){
            int size=que.size();
           
            while(size-->0){
                TreeNode node=que.removeFirst();
                if(node.left==null){
                    node.left=new TreeNode(val);
                    return node.val;
                }else{
                    que.add(node.left);
                }
            if(node.right==null){
                node.right=new TreeNode(val);
                return node.val;
                
            }
               else{
                    que.add(node.right);
                }
            }
            
        }
        
        return -1;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */