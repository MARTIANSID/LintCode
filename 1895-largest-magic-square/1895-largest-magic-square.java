class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] row=new int[n][m];
        int[][] col=new int[m][n];
     
        //solving for row prefix sum
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum+=grid[i][j];
                row[i][j]=sum;
            }
        }
        //solving for col prefix sum
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=grid[j][i];
                col[i][j]=sum;
            }
        }
      
        int max=1;  //every single point is a magic square
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //explore all possible squares for each point
                for(int k=1;k<Math.min(m-j,n-i);k++){
                    
                    //checking for row sum and col sum
                    //current row inclusive of j and j+k
                    int rs=rowSum(i,j,j+k,row),cs=colSum(j,i,i+k,col);
                    boolean flag=true;
                   for(int r=1;r<=k;r++){
                       if(rs!=rowSum(i+r,j,j+k,row)){
                           flag=false;
                           break;
                       }
                       
                       if(cs!=colSum(j+r,i,i+k,col)){
                           flag=false;
                           break;
                       }
                   }
                    if(!flag)continue;
                    
                    //calculate right diagonal sum
                    int rd=0;
                    for(int d=0;d<=k;d++){
                        rd+=grid[i+d][j+d];
                    }
                    int ld=0;
                    for(int d=0;d<=k;d++){
                        ld+=grid[i+d][j+k-d];
                    }
                    if(rd!=ld)continue;
                    
                    if(cs!=rd)continue;
                    
                 
                    max=Math.max(max,k+1);
                    
                }
                
            }
        }
      
        return max;
        
    }
    
    private int rowSum(int row,int col1,int col2,int[][] prefix){
        return col1==0?prefix[row][col2]:prefix[row][col2]-prefix[row][col1-1];
    }
    
    private int colSum(int col,int row1,int row2,int[][] prefix){
        return row1==0?prefix[col][row2]:prefix[col][row2]-prefix[col][row1-1];
    }
    
}