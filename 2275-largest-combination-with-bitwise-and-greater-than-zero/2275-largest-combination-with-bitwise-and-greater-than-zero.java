class Solution {

    public int largestCombination(int[] candidates) {
        int n = candidates.length, max = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int ele : candidates) {
                int x = (1 << i);
                if ((ele&x) != 0) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
