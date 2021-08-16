class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        int max = 0;
        for (Job j : arr) {
            max = Math.max(max, j.deadline);
        }
        int[] p = new int[max + 1];

        Arrays.sort(arr, (a, b) -> {
            return b.profit - a.profit;
        });

        Arrays.fill(p, -1);

        int totalProfit = 0, jobsDone = 0;

        for (Job j : arr) {
            for (int i = j.deadline; i >= 1; i--) {
                if (p[i] == -1) {
                    p[i] = j.id;
                    totalProfit += j.profit;
                    jobsDone++;
                    break;
                }
            }
        }

        return new int[] { jobsDone, totalProfit };

    }

}
