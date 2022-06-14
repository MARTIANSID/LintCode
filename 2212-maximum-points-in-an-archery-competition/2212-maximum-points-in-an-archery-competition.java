class Solution {

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length, max = 0;
        int[] ans = new int[n];

        for (int i = 0; i <= (1 << n); i++) {
            int score = 0, arrows = numArrows;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    if (arrows >= aliceArrows[j] + 1) {
                        arrows -= aliceArrows[j] + 1;
                        arr[j] = aliceArrows[j] + 1;
                        score += j;
                    }
                }
            }

            if (score > max) {
                for (int k = 0; k < n; k++) {
                    ans[k] = arr[k];
                    if (arrows != 0 && ans[k] > 0) {
                        ans[k] = ans[k] + arrows;
                        arrows = 0;
                    }
                }
                max = score;
            }
        }
        return ans;
    }
}
