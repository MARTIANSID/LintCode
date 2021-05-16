



class Solution {
        //adj technique same as paint house and house robber tech
    public int LISS(Node node){
        
        
      return solve(node,0);
        
        //Write your code here       
    }
    
    public int  solve(Node node,int adj){
        
        if(node==null){
            return 0;
        }
        
   
   
    if(adj==1){
        int ans=solve(node.left,0)+solve(node.right,0);
        return ans;
        
    }else{
        
        int x=solve(node.left,1)+solve(node.right,1)+1;
        
        int y=solve(node.right,0)+solve(node.left,0);
        
        return Math.max(x,y);
        
    }
    
        
        
    }
}