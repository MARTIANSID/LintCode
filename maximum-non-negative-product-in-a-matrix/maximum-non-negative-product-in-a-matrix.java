class Solution {
        int mod=(int)1e9+7;
    public int maxProductPath(int[][] grid) {
             long[][] dp1=new long[grid.length+1][grid[0].length+1];
        long[][] dp2=new long[grid.length+1][grid[0].length+1];
            
      long x=  solve(grid,0,0,dp1,dp2)[0];
            
          

            
            return x<0?-1:(int)(x%mod);
    }
        
        public long[] solve(int[][] grid,int row,int col,long[][] dp1,long[][] dp2){
                
                
                if(row==grid.length-1&&col==grid[0].length-1){
                        dp1[row][col]=grid[row][col];
                        dp2[row][col]=grid[row][col];
                        return new long[]{grid[row][col],grid[row][col]};
                }
                if(dp1[row][col]!=0&&dp2[row][col]!=0)return new  long[]{dp1[row][col],dp2[row][col]};
                
                 long[] r=new long[2];
                 long[] c=new long[2];

             long[] a=new long[2];  
                a[1]=-(long)1e9;
                a[0]=-(long)1e9;
                r[1]=-(long)1e9;
                r[0]=-(long)1e9;
                c[0]=-(long)1e9;
                c[1]=-(long)1e9;
             if(row+1<grid.length)   
         r=    solve(grid,row+1,col,dp1,dp2);
                  if(col+1<grid[0].length)  
       c=  solve(grid,row,col+1,dp1,dp2); 
                
                long max=-(long)1e9;
                long min=(long)1e9;
                for(int i=0;i<r.length;i++){
                       
                        if(r[i]==-(long)1e9){
                            continue;

                        }else{
                                 max=Math.max(max,r[i]*grid[row][col]);
                       
                        min=Math.min(min,r[i]*grid[row][col]);
                        }
                   
                }
                
                for(int i=0;i<c.length;i++){
                        
                        if(c[i]==-(long)1e9){
                             continue;
                        }else{
                                  max=Math.max(max,c[i]*grid[row][col]);
                        
                        min=Math.min(min,c[i]*grid[row][col]);  
                        }
                      
                      
                }
                
                
                a[0]=max;
                a[1]=min;
                
                dp1[row][col]=max;
                        dp2[row][col]=min;
                return a;

        
        }
}