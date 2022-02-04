class Solution {

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];

        int[] cur_row = new int[s.length() + 1];
        int[] next_row = new int[s.length() + 1];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    cur_row[j] = 1;
                    continue;
                }
                if (j < i) {
                    cur_row[j] = 0;
                    continue;
                }

                int size = 0;
                int count = 0;
                if (s.charAt(i) == s.charAt(j)) {
                    count += next_row[j - 1] + 2;
                } else {
                    count += Math.max(next_row[j], cur_row[j - 1]);
                }

                cur_row[j] = count;
            }
            next_row=cur_row;
            if(i!=0)
                cur_row=new int[s.length()+1];
        }
        return cur_row[s.length() - 1];
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
