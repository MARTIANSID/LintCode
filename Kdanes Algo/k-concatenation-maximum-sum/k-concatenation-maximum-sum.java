class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {

        long sum = 0;
        int n = arr.length;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            sum = (sum + arr[i]) % mod;
        }

        if (k == 1) {
            long global = 0;
            long currSum = 0;
            for (int i = 0; i < arr.length; i++) {
                currSum = (currSum + arr[i % n]) % mod;
                currSum = Math.max(arr[i % n], currSum);
                global = Math.max(global, currSum);
            }

            return (int) global % mod;
        }

        if (sum <= 0) {
            long global = 0;
            long currSum = 0;
            for (int i = 0; i < 2 * arr.length; i++) {
                currSum = (currSum + arr[i % n]) % mod;
                currSum = Math.max(arr[i % n], currSum);
                global = Math.max(global, currSum);
            }

            return (int) global % mod;

        } else {

            long[] left = new long[n];
            long[] right = new long[n];

            long currSum = 0;
            for (int i = 0; i < arr.length; i++) {
                currSum = (currSum + arr[i]) % mod;
                currSum = Math.max(arr[i], currSum);
                left[i] = currSum;
            }

            currSum = 0;
            for (int i = n - 1; i >= 0; i--) {
                currSum = (currSum + arr[i]) % mod;
                currSum = Math.max(arr[i], currSum);
                right[i] = currSum;
            }

            return (int) ((left[n - 1] + right[0] + sum * (k - 2)) % mod);

        }

    }
}

// cases 1
// [-1,-2,-3,100] [-1,-2,-3,100]
// 100 194
// [1,2,]

// [1,3,100,-50,-10] [1,3,100, ]