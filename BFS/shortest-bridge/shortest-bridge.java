class Solution {
    public int shortestBridge(int[][] A) {
           int m=A[0].length;
            boolean flag=false;
            boolean[][] visited=new boolean[A.length][A[0].length];
     
           for(int i=0;i<A.length;i++){
                   for(int j=0;j<A[0].length;j++){
                           if(A[i][j]==1){
                                   flag=true;
                             dfs(A,i,j,visited);  
                                   break;
                                
                           }
                         
                   }
                     if(flag)break;
                  
           }
//           
            
             // for(int i=0;i<A.length;i++){
             //       for(int j=0;j<A[0].length;j++){
             //               System.out.println(visited[i][j]);
             //       }
             // }
            
            
           int ans=(int)1e9;
             for(int i=0;i<A.length;i++){
                   for(int j=0;j<A[0].length;j++){
                           if(visited[i][j]){
                                      LinkedList<Integer>  que=new LinkedList<>();
                                   que.add(i*m+j);
                                  int val= bfs(que,A,visited);
                                                                     

                                 
                                   ans=Math.min(val,ans);
                           }
                   }
                  
           }
            
            
            
            
            
             return ans;
    }
        public void dfs(int[][] A,int row,int col,boolean[][] visited){
                
                if(row<0||col<0||row>=A.length||col>=A[0].length||A[row][col]==0||visited[row][col]){
                        return;
                }
        
                visited[row][col]=true;
                
                
                dfs(A,row+1,col,visited);
                dfs(A,row,col+1,visited);
                dfs(A,row-1,col,visited);
                dfs(A,row,col-1,visited);


                
        }
        
         public int bfs(LinkedList<Integer> que,int[][] a,boolean[][] visited){
              
                          int[][] dir=new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
                        int m=a[0].length;
                        int n=a.length;
                        int level=0;
                                 boolean[][] visited2=new boolean[n][m];

                        while(que.size()!=0){
                                int size=que.size();
                                
                              
                                while(size-->0){
                                        
                                        
                                         int point=que.removeFirst();
                                        
                                        
                               
                               
                                int r=point/m;
                                int c=point%m;
                                        
                                        
                                        
                                       
                                
                     for (int d = 0; d < dir.length; d++)
            {
                        int x = r + dir[d][0];
                        int y = c + dir[d][1];
                            
 if (x >= 0 && y >= 0 && x < n && y < m&&a[x][y]==1&&visited[x][y]!=true)return level;
                if (x >= 0 && y >= 0 && x < n && y < m && a[x][y] == 0&&visited2[x][y]!=true)
                {
                        
                      
                        
                 visited2[x][y]=true;
                      
                       
                    que.add(x * m + y);
                }
            }
                                        
                                }
                                level++;
                        }
                        
                        return (int)1e9;
                        
                }
            
}