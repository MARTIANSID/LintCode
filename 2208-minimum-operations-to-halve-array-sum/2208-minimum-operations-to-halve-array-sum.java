class Solution {

    public int halveArray(int[] nums) {
        int n = nums.length, operations = 0;
        double sum = 0, halfSum = 0;

        PriorityQueue<Double> pq = new PriorityQueue<>(
            (a, b) -> {
                return Double.compare(b, a);
            }
        );

        for (int ele : nums) {
            sum += ele;
            pq.add((double)ele);
        }
        halfSum = sum / 2;

        while (sum > halfSum) {
            double ele = pq.poll();
            sum -= ele / 2;
            pq.add(ele / 2);
            operations++;
        }
        return operations;
    }
}
