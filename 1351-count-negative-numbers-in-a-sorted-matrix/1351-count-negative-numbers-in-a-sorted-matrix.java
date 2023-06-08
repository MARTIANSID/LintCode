class Solution {
    public int countNegatives(int[][] grid) {
        int n=grid.length,m=grid[0].length,i=0,j=m-1,count=0;
        
        while(i<n && j>=0){
            if(grid[i][j]<0){
                count+=n-i;
                j--;
            }else{
                i++;
            }
        }
        return count;
    }
}