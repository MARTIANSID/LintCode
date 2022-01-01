class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] right=new int[n][m];
        int[][] down=new int[n][m];
        
        
        //up calculations
        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                if(grid[i][j]==1){
                    if(j==m-1){
                        right[i][j]=1;
                    }else{
                        right[i][j]=right[i][j+1]+1;
                    }
                }else{
                    right[i][j]=0;
                }
            }
        }
        
        //down calculations
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(i==n-1){
                        down[i][j]=1;
                    }else{
                        down[i][j]=down[i+1][j]+1;
                    }
                }else{
                    down[i][j]=0;
                }
            }
        }
        
        
        int max =0;
        
        //answer calculations 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int min=Math.min(down[i][j],right[i][j]);
                if(min==1){
                    max=Math.max(max,1);
                    continue;
                }else if(min==0){
                    continue;
                }
                for(int u=1;u<min;u++){
                    int x=Math.min(down[i][j+u],right[i+u][j]);
                    if(x==1||x<u+1)continue;
                    x=Math.min(x,u+1);
                    max=Math.max(max,x*x);
                }
            }
        }
        
        return max;
        
    }
}


