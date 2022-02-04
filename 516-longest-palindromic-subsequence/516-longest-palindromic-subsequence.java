class Solution {

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (j < i) {
                    dp[i][j] = 0;
                    continue;
                }

                int size = 0;
                int count = 0;
                if (s.charAt(i) == s.charAt(j)) {
                    count += dp[i + 1][j - 1] + 2;
                } else {
                    count += Math.max(dp[i + 1][j], dp[i][j - 1]);
                }

                dp[i][j] = count;
            }
        }
        return dp[0][s.length()-1];

    }
}
        // public int solve(String s,int i,int j,int[][] dp){
//                 if(i==j){
//                         return dp[i][j]= 1;
//                 }
//                 if(j<i){
//                         return dp[i][j]=0;
//                 }
//                 if(dp[i][j]!=-1)return dp[i][j];
//                 int size=0;
//                 int count=0;
//         if(s.charAt(i)==s.charAt(j)){
//                count+= solve(s,i+1,j-1,dp)+2;
//         }else{
//             count+=   Math.max( solve(s,i+1,j,dp),solve(s,i,j-1,dp));
//         }
//                 return dp[i][j]=count;
//         }
