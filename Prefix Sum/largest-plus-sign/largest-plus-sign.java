class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
         int size=mines.length;
        
        
        int[][] matrix=new int[n][n];
        
        for(int[] row:matrix)Arrays.fill(row,1);
        
        for(int i=0;i<size;i++){
            matrix[mines[i][0]][mines[i][1]]=0;
        }
        
        int[][] top=new int[n][n];
        int[][] down=new int[n][n];
        int[][] left=new int[n][n];
        int[][] right=new int[n][n];
        
        
        //top to down
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    top[i][j]=0;
                }else{
                    int x=(i-1>=0)?top[i-1][j]:0;
                    top[i][j]+=1 +x;
                }
            }
        }
        
        
        //down to top
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    down[i][j]=0;
                }else{
                    int x=i+1<n?down[i+1][j]:0;
                    down[i][j]+=1 +x;
                }
            }
        }
        
        //left to right
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[j][i]==0){
                    left[j][i]=0;
                }else{
                    int x=(i-1)>=0?left[j][i-1]:0;
                    left[j][i]+=1 +x;
                }
            }
        }
        
        
        //right to left
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(matrix[j][i]==0){
                    right[j][i]=0;
                }else{
                    int x=i+1<n?right[j][i+1]:0;
                    right[j][i]+=1+x;
                }
            }
        }
        
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               int min=Math.min(Math.min(left[i][j],right[i][j]),Math.min(top[i][j],down[i][j]));
                max=Math.max(max,min);
            }
        }
        
        
        return max;
        
        
        
        
        
    }
}