
class Solution {
    class TreeNode{
        int val;
        int index;
        TreeNode left;
        TreeNode right;
        TreeNode(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
         PriorityQueue<TreeNode> pq=new PriorityQueue<>((a,b)->{
            if(a.val==b.val){
                return 1;
            }else{
                return a.val-b.val;
            }
             });
         
         for(int i=0;i<f.length;i++){
             pq.add(new TreeNode(f[i],i));
         }
            
         while(pq.size()!=1){
             TreeNode n1=pq.poll();
             TreeNode n2=pq.poll();
             TreeNode n=new TreeNode(n1.val+n2.val,(int)1e9);
             n.left=n1;
             n.right=n2;
             pq.add(n);
            
         }
         TreeNode root=pq.poll();
         ArrayList<String> ans=new ArrayList<>();
         preorder(root,"",ans);
         return ans;
    }
    public void preorder(TreeNode root,String asf,ArrayList<String> ans){
        
        if(root==null)return;
        if(root.left==null&&root.right==null){
            ans.add(asf);
        }
        
            preorder(root.left,asf+"0",ans);
            preorder(root.right,asf+"1",ans);
    }
    
    
}