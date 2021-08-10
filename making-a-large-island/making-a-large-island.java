class Solution {
    
    public static int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int largestIsland(int[][] grid) {
        
    HashMap<Integer,Integer> map=new HashMap<>();
        int n=grid.length;
        int m=grid[0].length;
        
        
        map.put(0,0);
        
        int max=0;
        int index=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                   int a= dfs(i,j,grid,index);
                    max=Math.max(max,a);
                    map.put(index,a);
                    index++;
                }
            }
        }
        
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    
                    int area=0;
                    HashSet<Integer> set=new HashSet<>();
                   for(int k=0;k<dir.length;k++){
                       int r=i+dir[k][0];
                       int c=j+dir[k][1];
                       
                       if(r>=0&&c>=0&&r<n&&c<m){
                           if(!set.contains(grid[r][c])){
                               area+=map.get(grid[r][c]);
                               set.add(grid[r][c]);
                           }
                           
                       }
                   }
                    
                    max=Math.max(area+1,max);
                    
                }
            }
        }
        
        // System.out.println(map);
        
        return max;
        
      
    }
    
      public int dfs(int r,int c,int[][] grid,int index){
            
            if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]!=1){
                return 0;
            }
            
            
            grid[r][c]=index;
            
            
            return 1+dfs(r+1,c,grid,index)+dfs(r,c+1,grid,index)+dfs(r-1,c,grid,index)+dfs(r,c-1,grid,index);
        }
}