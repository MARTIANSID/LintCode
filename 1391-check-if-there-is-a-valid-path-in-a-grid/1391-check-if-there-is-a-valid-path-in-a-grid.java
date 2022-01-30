class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        
        dfs(grid,0,0,visited,'F');
        
        return visited[n-1][m-1];
    }
    
    public boolean dfs(int[][] grid,int row,int col,boolean[][] visited,char direction){
        
        if(row>=grid.length||col>=grid[0].length||row<0||col<0||visited[row][col])return false;
        
         int val=grid[row][col];
        
        if(direction=='L'){
            if(val!=1&&val!=3&&val!=5)return false;
            
        }else if(direction=='R'){
            if(val!=4&&val!=6&&val!=1)return false;
            
        }else if(direction=='T'){
            if(val!=2&&val!=6&&val!=5)return false;
        }else if(direction=='D'){
            if(val!=2&&val!=3&&val!=4)return false;
        }
        
        visited[row][col]=true;
        
        if(row==grid.length-1&&col==grid[0].length-1)return true;
        
       
        
        if(val==1){
            return dfs(grid,row,col+1,visited,'L')||dfs(grid,row,col-1,visited,'R');
        }else if(val==2){
            return dfs(grid,row+1,col,visited,'T')||dfs(grid,row-1,col,visited,'D');
        }else if(val==3){
             return dfs(grid,row+1,col,visited,'T')||dfs(grid,row,col-1,visited,'R');
        }else if(val==4){
             return dfs(grid,row+1,col,visited,'T')||dfs(grid,row,col+1,visited,'L');
        }else if(val==5){
             return dfs(grid,row-1,col,visited,'D')||dfs(grid,row,col-1,visited,'R');
        }else{
             return dfs(grid,row-1,col,visited,'D')||dfs(grid,row,col+1,visited,'L');
        }
        
        
    }
}