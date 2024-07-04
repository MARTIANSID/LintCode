class Solution {
    Integer[][] dp;

    public int findRotateSteps(String ring, String key) {
        dp = new Integer[ring.length()][key.length()];

        return dfs(ring, key, 0, 0);
    }

    public int dfs(String ring, String key, int currIndexRing, int currIndexKey) {
        if (currIndexKey >= key.length()) return 0;

        int n = ring.length();

        int min = (int) 1e9;

        if (dp[currIndexRing][currIndexKey] != null) {
            return dp[currIndexRing][currIndexKey];
        }

        for (int i = 0; i < n; i++) {
            if (ring.charAt(i) == key.charAt(currIndexKey)) {
                int clockwiseDistance = n - Math.abs(i - currIndexRing);
                int anticlockwiseDistance = Math.abs(i - currIndexRing);

                int clockwisePath = clockwiseDistance + 1 + dfs(ring, key, i, currIndexKey + 1);
                int anticlockwisePath = anticlockwiseDistance + 1 + dfs(ring, key, i, currIndexKey + 1);

                min = Math.min(min, Math.min(clockwisePath, anticlockwisePath));
            }
        }
        return dp[currIndexRing][currIndexKey] = min;
    }
}
// abcd, key = "bc"
//     (1,1)
//     (1,1)
// dfs(clockwise)
// anticlockwise
// min(clockwise,antiwise)
/*

anticlockwise = absDiff btw (g,d) 
clockwise = len - absDii btw (g,d)


ring = godding
0 - 1 = -1 % 7 = 6
-1 - 1 = -2 % 7 = 5

6 - 7 % 7 = 0

g

for i in arr.size():
    anticlockwise = absDiff btw (g,d) 
    clockwise = len - absDii btw (g,d)
    
    dfs(anticlockwise)
    dfs(clockwise)
    



*/
