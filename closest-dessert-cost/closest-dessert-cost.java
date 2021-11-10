class Solution {
    int ans=(int)1e9;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
     
        for(int ele:baseCosts){
            solve(toppingCosts,target,ele,0);
        }
   
        return ans;
    }
    
    public void solve(int[] toppingCosts,int target,int cost,int index){
    
        
        if(cost>=target||index>=toppingCosts.length){
            if(Math.abs(ans-target)>Math.abs(target-cost)){
                ans=cost;
            }else if(Math.abs(ans-target)==Math.abs(target-cost)){
                ans=Math.min(ans,cost);
            }
            return;
        }
        
       
        for(int i=0;i<3;i++){
               solve(toppingCosts,target,cost+toppingCosts[index]*i,index+1); 
        }
        
        
    }
}