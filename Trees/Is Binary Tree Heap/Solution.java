class Solution
{
	boolean isHeap(Node tree)
	{
	        int n=size(tree);
	        return check(tree,n,0);
	       
	}
	
    public int size(Node tree){
        if(tree==null)return 0;
        
        return 1+size(tree.left)+size(tree.right);
    }
    
    public boolean check(Node root,int n,int index){
        
        if(root==null)return true;
        
        if(index>=n)return false;
        
        
        if(root.left!=null&&root.data<root.left.data||root.right!=null&&root.data<root.right.data)return false;
        
        
        return check(root.left,n,2*index+1)&&check(root.right,n,2*index+2);
        
        
        
    }
	
}