class Solution {
    public int countNegatives(int[][] grid) {
           int n=grid.length,m=grid[0].length,i=0,j=m-1, count=0;
        
        while(j>=0&&i<n){
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




// [4,3,2,-1]
// [3,2,1,-1]
// [1,1,-1,-2]
// [-1,-1,-2,-3]