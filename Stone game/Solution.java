class Solution {
    public boolean stoneGame(int[] piles) {
     
           return solve(piles,0,0,1)>0?true:false;
    }
        
        public int solve(int[] piles,int i,int j,int player){
                
                if(j<i)return 0;
                
                
                if(player==1){
                        
                        int x=solve(piles,i+1,j,0)+piles[i];
                       int y= solve(piles,i,j-1,0) +piles[j];
                        return Math.max(x,y);
                        
                }else{
                        
                         int x=solve(piles,i+1,j,1)-piles[i];
                       int y= solve(piles,i,j-1,1) -piles[j];
                        
                       return Math.min(x,y); 
                        
                }
                
                
                
        }
}