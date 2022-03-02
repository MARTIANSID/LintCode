class Solution {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int no = i, cnt = 0;

            while (no>0) {
                if ((no & 1) != 0) cnt++;

                no = (no >> 1);
            }

            ans[i] = cnt;
        }

        return ans;
    }
}
