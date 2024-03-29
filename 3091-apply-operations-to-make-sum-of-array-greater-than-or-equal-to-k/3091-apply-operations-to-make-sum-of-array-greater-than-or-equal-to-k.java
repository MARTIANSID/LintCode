class Solution {

    public int minOperations(int k) {
        int min = (int)1e9, ops = 0;

        for (int i = 1; i <= k; i++) {
            int x = (k / i);
            int rem = (k % i);

            if (rem > 0) {
                x++;
            }

            min = Math.min(min, (x-1) + (i-1));
        }

        return min;
    }
}
