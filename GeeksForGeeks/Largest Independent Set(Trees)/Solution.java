
class Solution {

    // either exclude or include the current node,if we include the current then we cant include its neighbours left and right
    public int LISS(Node node){
        
        
      return solve(node);
        
        //Write your code here       
    }
    
    public int  solve(Node node){
        
        if(node==null){
            return 0;
        }
        
      int inc=  solve(node.left)+solve(node.right);
        
    int exc=1;
    
    if(node.left!=null)
    exc+=solve(node.left.left)+solve(node.left.right);
    
    if(node.right!=null)
    exc+=solve(node.right.right)+solve(node.right.left);
    
    
    return Math.max(inc,exc);
    
    
        
        
    }
}