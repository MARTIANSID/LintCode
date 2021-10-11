class Solution {
    public long gridGame(int[][] grid) {
       
        int m=grid[0].length;
        
        long  topSum=0,bottomSum=0;
        
        for(int i=0;i<m;i++){
            topSum+=grid[0][i];
        }
        
        long ans=(long)1e12;
        for(int i=0;i<m;i++){
            topSum-=grid[0][i];
            ans=Math.min(ans,Math.max(topSum,bottomSum));
            bottomSum+=grid[1][i];
        }
        return ans;
    }
}