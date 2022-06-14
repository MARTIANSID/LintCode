class Solution {

    /*
        we form 2 subsets  (do by masking)
        for each subset find longest palindromic subsequence (dp problem)
    */
    Integer[][] dp;
    public int maxProduct(String s) {
        int n = s.length();
     
        s=new String(new StringBuilder(s).reverse());

        int max = 0;

        for (int i = 0; i < (1 << n); i++) {
            StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                char ch = s.charAt(j);
                if ((i & (1 << j)) == 0) {
                    sb1.append(ch);
                } else {
                    sb2.append(ch);
                }
            }
            String s1 = new String(sb1), s2 = new String(sb2);
            dp=new Integer[n][n];
            int l1 = lps(s1, 0, s1.length() - 1);
            dp=new Integer[n][n];
            int l2 = lps(s2, 0, s2.length() - 1);
     
            max = Math.max(max, l1 * l2);
        }
        return max;
    }

    public int lps(String s, int i, int j) {
        if (i > j) return 0;
        
        if(i==j)return 1;
        
        if(dp[i][j]!=null)return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j]=lps(s, i + 1, j - 1) + 2;
        } else {
            return dp[i][j]=Math.max(lps(s, i + 1, j), lps(s, i, j - 1));
        }
    }
}
