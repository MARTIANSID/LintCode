class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n=mat.length;
        int m=mat[0].length;
        int[][]  matrix=new int[n+1][m+1];
        
         for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                matrix[i][j]=matrix[i][j-1]+matrix[i-1][j]-matrix[i-1][j-1]+mat[i-1][j-1];
            }
        }
        
        int li=0,hi=Math.min(n,m)-1;
        
        while(li<=hi){
            int mid=(li+hi)/2;
            if(isPossible(matrix,threshold,mid))li=mid+1;
            else hi=mid-1;
        }
    
        return li;
    }
    
    public boolean isPossible(int[][] matrix,int threshold,int k){
        int n=matrix.length-1;
        int m=matrix[0].length-1;
          for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int row1=Math.max(0,i)+1;
                if(i+k>n-1)continue;
                int row2=Math.min(n-1,i+k)+1;
                
                int col1=Math.max(0,j)+1; 
                if(j+k>m-1)continue;
                int col2=Math.min(m-1,j+k)+1;
    int val=matrix[row2][col2]-matrix[row2][col1-1]-matrix[row1-1][col2]+matrix[row1-1][col1-1];
                if(val<=threshold)return true;
                
            }
        }
        return false;
    }
}