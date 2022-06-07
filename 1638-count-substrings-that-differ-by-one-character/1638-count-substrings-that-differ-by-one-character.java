class Solution {
    public int countSubstrings(String s, String t) {
        int n=s.length();
        int m=t.length();
        
        
        int[][] dp=new int[n][m];  //this will contain same characters substring ending at i,j
        
        int[][] dp1=new int[n][m];
        
        int ans=0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j]=1+((i+1<n && j+1<m)?dp[i+1][j+1]:0);
                    dp1[i][j]=((i+1<n && j+1<m)?dp1[i+1][j+1]:0);
                    ans+=((i+1<n && j+1<m)?dp1[i+1][j+1]:0);
                }else{
                    dp1[i][j]=1+((i+1<n && j+1<m)?dp[i+1][j+1]:0);
                    ans+=dp1[i][j];
                }
            }
        }
        return ans;
        
    }
}