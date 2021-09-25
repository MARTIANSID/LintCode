class Solution {
    
    class pair{
        int r;
        int c;
        int obs;
        pair(int r,int c,int obs){
            this.r=r;
            this.c=c;
            this.obs=obs;
        }
    }
    public static int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int shortestPath(int[][] grid, int k) {
        LinkedList<pair> que=new LinkedList<>();
       
        
        que.add(new pair(0,0,k));
        
        
        int n=grid.length;
        int m=grid[0].length;
        int level=0;
         boolean[][][] visited = new boolean[n][m][k+1];
        visited[0][0][k]=true;
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
              pair p=  que.poll();
            int r=p.r;
            int c=p.c;
            int ob=p.obs;
                if(r==n-1&&c==m-1)return level;
                
            for(int i=0;i<dir.length;i++){
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr<n&&nc<m&&nr>=0&&nc>=0){
                    
                    if(grid[nr][nc]==1&&ob>0){
                       
                        if(!visited[nr][nc][ob])
                        {
                            que.add(new pair(nr,nc,ob-1));
                             visited[nr][nc][ob]=true;
                        }
                    }
                    
                    if(grid[nr][nc]==0){
                         if(!visited[nr][nc][ob]){
                              que.add(new pair(nr,nc,ob));
                                visited[nr][nc][ob]=true;

                         }
                       
                    }
                }
                
            }
                
            }
            level++;
        }
        
        return -1;
        
    }
}