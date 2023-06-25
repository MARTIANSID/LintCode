class Solution {
    int mod = (int) 1e9 + 7;
    Long[][] dp;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        dp = new Long[fuel + 1][locations.length + 2];

        return (int) (solve(locations,start, finish, fuel) % mod);
    }

    public long solve(int[] locations, int start, int finish, int fuel) {
        if (dp[fuel][start] != null) return dp[fuel][start];

        long cnt = 0;

        if (start == finish) cnt++;
        
      

        for (int i = 0; i < locations.length; i++) {
            if (start == i) continue;

            if ((fuel - Math.abs(locations[start] - locations[i]) >= 0)) {
                cnt = (cnt + solve(locations, i, finish, fuel - Math.abs(locations[start]-locations[i]))) % mod;
            }
        }
        return dp[fuel][start] = cnt;
    }
}
