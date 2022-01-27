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
   LinkedList<TreeNode> que;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root=root;
        this.que=new LinkedList<>();
        que.add(root);
        
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                TreeNode node=que.peekFirst();
                if(node.left!=null){
                    que.add(node.left);
                }
                
                if(node.right!=null){
                    que.add(node.right);
                }
                if(node.right==null||node.left==null)return;
                que.removeFirst();
            }
        }
    }
    
    public int insert(int val) {
       TreeNode node= que.peekFirst();
        if(node.left==null){
            node.left=new TreeNode(val);
            que.add(node.left);
        }else if(node.right==null){
            node.right=new TreeNode(val);
            que.add(node.right);
        }
        
        if(node.left!=null&&node.right!=null)que.removeFirst();
        return node.val;
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