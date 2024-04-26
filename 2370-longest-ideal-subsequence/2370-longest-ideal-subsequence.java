class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        
        int[] dp = new int[26];
        
        int finalAnswer = 0;
        
        for(int i = n - 1; i>=0; i--){
            char ch = s.charAt(i); // d
            
            int max = 0;
            
            for(int j = 0; j<=k; j++){
                int endCharacter = (ch-'a') + j;
                int startCharacter = (ch-'a') - j;
                
                if(endCharacter < 26)
                max = Math.max(max,dp[endCharacter]);
                
                if(startCharacter >= 0)
                max = Math.max(max, dp[startCharacter]);
            }
            dp[ch-'a'] = max+1;
            finalAnswer = Math.max(dp[ch-'a'],finalAnswer);
        }
        
        return finalAnswer;
        
    }
}

// {
//     "c" : x1
//     "f" : x2
//     "g" : x3
//     "b" : x4
//     "d" : x5
//     "a" : max(x1,x4)+1
// }


// "acfgbd", k = 2