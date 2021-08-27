class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=1;i<n;i++){
            int min1=(int)1e9,min2=(int)1e9,c1=-1,c2=-1;
            for(int j=0;j<m;j++){
                if(grid[i-1][j]<=min1){
                    min2=min1;
                    c2=c1;
                    min1=grid[i-1][j];
                    c1=j;
                }else if(grid[i-1][j]<min2){
                    min2=grid[i-1][j];
                    c2=j;
                }
            }
            
            for(int j=0;j<m;j++){
                if(j!=c1){
                    grid[i][j]+=min1;
                }else if(j!=c2){
                    grid[i][j]+=min2;
                }
            }
        }
        
        int om=(int)1e9;
        for(int i=0;i<m;i++){
            om=Math.min(om,grid[n-1][i]);
        }
        
        return om;
    }
    
}