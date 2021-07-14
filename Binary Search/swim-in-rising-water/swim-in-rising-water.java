class Solution {
    public int swimInWater(int[][] grid) {
      
            
            int n=grid.length;
            
              PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
                int r1=a/n,c1=a%n;
                int r2=b/n,c2=b%n;
                return grid[r1][c1]-grid[r2][c2];      
        });
            int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
            boolean[][] visited=new boolean[n][n];
            int time=0;
            int minHeight=0;
            visited[0][0]=true;
            pq.add(0);
       while(pq.size()!=0) {
               int size=pq.size();
               while(size-->0){
                       int point=pq.poll();
                       int r =point/n;
                       int c=point%n;
                       
                       
                     minHeight=Math.max(minHeight,grid[r][c]);
                       
                       
                        if(r==n-1&&c==n-1)return minHeight;
                       
                       
                      for(int i=0;i<dir.length;i++){
                              int r1=r+dir[i][0];
                              int c1=c+dir[i][1];
                              
                          if(r1>=0&&c1>=0&&r1<n&&c1<n&&visited[r1][c1]!=true){
                                  
                                  pq.add(r1*n+c1);
                                  visited[r1][c1]=true;
                          }    
                              
                      }
                      
               }
       }
            return minHeight;
    }
}