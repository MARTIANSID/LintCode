class Solution {

    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][2];
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        dp[n - 1][0] = true;
        dp[n-1][1] = true;
        int ans = 1;
        tree.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Integer lesser = tree.floorKey(arr[i]);
            Integer greater = tree.ceilingKey(arr[i]);

            //odd
            if (greater != null && arr[i]<=greater) {
                int index = tree.get(greater);
                
                if (dp[index][1]) {
                    dp[i][0] = true;
                   
                }
            }

            
            //even
            if (lesser != null && arr[i]>=lesser) {
                int index = tree.get(lesser);
                if (dp[index][0]) {
                    dp[i][1] = true;
                
                }
            }

            tree.put(arr[i], i);

            if (dp[i][0]) {
                ans++;
            }
        }
        return ans;
    }
}
