class Solution {
        int m=0;
    public boolean containsCycle(char[][] grid) {
        m=grid[0].length;
           boolean[][] visited=new boolean[grid.length][grid[0].length];
           for(int i=0;i<grid.length;i++){
                   for(int j=0;j<grid[0].length;j++){
                         if(!visited[i][j]){
                                 boolean x=dfs(grid,visited,i,j,i*m+j,0,grid[i][j]);
                                 
                                 if(x){
                                       

                                         return true;
                                 }
                         }
                   }
                   
                  
           } 
             return false;
            
    }
        
        public boolean dfs(char[][] grid,boolean[][] visited,int row,int col,int p,int count,char ch){
                
                
                if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]!=ch)return false;
                
                
                if(visited[row][col]&&count>=3){
                       
                        return true;
                        }
                
             
          
                if(visited[row][col])return false;
                
                visited[row][col]=true;
                
                boolean one=false;
                boolean two=false;
                boolean three=false;
                boolean four=false;
                
                if(p!=(row+1)*m+col)
               one=  dfs(grid,visited,row+1,col,row*m+col,count+1,ch);
                if(one)return true;
                 if(p!=(row-1)*m+col)
               two= dfs(grid,visited,row-1,col,row*m+col,count+1,ch);
                                if(two)return true;

                 if(p!=(row)*m+col+1)
              three=   dfs(grid,visited,row,col+1,row*m+col,count+1,ch);
                                if(three)return true;

                 if(p!=(row)*m+col-1)
              four=   dfs(grid,visited,row,col-1,row*m+col,count+1,ch);
                                if(four)return true;

                
  
                
              return false;
               



                 
        }
}