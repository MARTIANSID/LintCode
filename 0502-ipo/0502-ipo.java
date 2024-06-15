class Solution {

    class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        Project[] projects = new Project[n];

        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(
            projects,
            (a, b) -> {
                return a.capital - b.capital;
            }
        );

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                return b - a;
            }
        ); // this will contain the profits of the projects that can be done

        int index = 0;

        while (k-- > 0) {
            while (index < n && projects[index].capital <= w) {
                pq.add(projects[index++].profit);
            }
            if (pq.size() == 0) {
                return w;
            }
            w += pq.poll();
        }

        return w;
    }
}
/*
atmost k distinct projects
project - > capital[i], profit[i]
initial capital - > w

*/
