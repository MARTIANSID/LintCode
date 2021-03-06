class Solution {
    
    
    /*
    logic - for n = 1 ans is a e i o u
     in the next round u can come bheind any string
     o can come behind all strings except except string ending at u
     i can come bheind all strings except string ending at o and u
     and so on the logic
     
    */

    public int countVowelStrings(int n) {
        int[] dp = new int[n];
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        dp[0] = 5;
        for (int k = 1; k < n; k++) {
            int uu = dp[k - 1];
            int oo = dp[k - 1] - u;
            int ii = dp[k - 1] - (o + u);
            int ee = dp[k - 1] - (o + u + i);
            int aa = dp[k - 1] - (o + u + i + e);
            dp[k] = uu + oo + ii + ee + aa;
            u = uu;
            o = oo;
            i = ii;
            e = ee;
            a = aa;
        }
        return dp[n - 1];
    }
}
