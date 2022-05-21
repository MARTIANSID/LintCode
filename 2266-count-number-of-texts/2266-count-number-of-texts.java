class Solution {
    int mod = (int) 1e9 + 7;
    Long[] dp;

    public int countTexts(String pressedKeys) {
        
        int n=pressedKeys.length();
        
        
        dp = new Long[n+1];

        for (int index = n; index >= 0; index--) {
            if (index == pressedKeys.length()) {
               dp[index]=(long)1;
                continue;
            }
            long count = 0;
            for (int i = 1; i <= 4; i++) {
                if (index + i - 1 == pressedKeys.length()) {
                    dp[index]=count;
                    break;
                }
                 if (pressedKeys.charAt(i + index - 1) != pressedKeys.charAt(index)) {
                     dp[index]=count;
                     break;
                 }
                if(i!=4){
                    count=(count+dp[index+i])%mod;
                }else if (pressedKeys.charAt(index) == '9' || pressedKeys.charAt(index) == '7')
                     count=(count+dp[index+i])%mod;
            }
            dp[index]=count;
        }
        return (int)(dp[0]%mod);
    }

//     public long solve(String pressedKeys, int index) {
//         if (index == pressedKeys.length()) {
//             return 1;
//         }

//         long count = 0;

//         if (dp[index] != null) return dp[index];

//         for (int i = 1; i <= 4; i++) {
//             if (index + i - 1 == pressedKeys.length()) return count;

//             if (pressedKeys.charAt(i + index - 1) != pressedKeys.charAt(index)) return count;

//             if (i != 4) count = (count + solve(pressedKeys, index + i)) % mod; else if (pressedKeys.charAt(index) == '9' || pressedKeys.charAt(index) == '7') count =
//                 (count + solve(pressedKeys, index + i)) % mod;
//         }
//         return dp[index] = count;
//     }
}
