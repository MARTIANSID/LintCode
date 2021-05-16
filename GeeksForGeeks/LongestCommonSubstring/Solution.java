
// topdown simple dp
class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        
       int[][] dp=new int[n+1][m+1];
       int max=0;
       
       for(int i=0;i<=n;i++){
           for(int j=0;j<=m;j++){
               
               if(i==0||j==0){
                   dp[i][j]=0;
               }
               
               else if(S1.charAt(i-1)==S2.charAt(j-1)){
                   dp[i][j]=1+dp[i-1][j-1];
                   max=Math.max(dp[i][j],max);
               }
               
              
       }
     
    }
      return max;
}
}