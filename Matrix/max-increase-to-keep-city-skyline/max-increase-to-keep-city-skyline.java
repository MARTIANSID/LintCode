class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //max in row has to be same
        // max in col has to be same
        int n=grid.length;
        int m=grid[0].length;
        
        int[] col=new int[m];
        int[] row=new int[n];
        
        
        int sum1=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                col[j]=Math.max(col[j],grid[i][j]);
                row[i]=Math.max(row[i],grid[i][j]);
                sum1+=grid[i][j];
            }
        }
        int sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                grid[i][j]=Math.min(col[j],row[i]);
                sum+=grid[i][j];
            }
        }
        return sum-sum1;
    }
}