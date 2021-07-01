class Solution {
        
        //binary search+dfs
    public int swimInWater(int[][] grid) {
        
           int si=0,ei=(int)1e9;
           int n=grid.length;
           int m=grid[0].length;
       
           
            while(si<=ei){
                    int mid=(si+ei)/2;
                     boolean[][] visited=new boolean[n][m];
                    if(dfs(grid,0,0,n,m,mid,visited)){
                            
                            ei=mid-1;
                    }else{
                           si=mid+1;
                    }
            }
            
            
            return si;
           
    }
        
        public boolean dfs(int[][] grid,int r,int c,int n,int m,int time,boolean[][] visited){
                
             if(r>=n||c>=m||r<0||c<0||visited[r][c]==true||grid[r][c]>time){
                     return false;
             }
                
               
             if(r==n-1&&c==m-1)return true;  
                visited[r][c]=true;
                
         return  dfs(grid,r+1,c,m,n,time,visited)||dfs(grid,r,c+1,m,n,time,visited)||dfs(grid,r-1,c,m,n,time,visited)||dfs(grid,r,c-1,m,n,time,visited);
             
                
        
                
                
                
                                
                
                
                
        }
}