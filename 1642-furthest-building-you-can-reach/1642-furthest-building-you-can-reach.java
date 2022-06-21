class Solution {

    public int furthestBuilding(int[] height, int bricks, int ladders) {
        int n = height.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                return b - a;
            }
        );

        for (int i = 0; i < n - 1; i++) {
            if (height[i] < height[i + 1]) {
                //if you have bricks use bricks
                if (height[i + 1] - height[i] <= bricks) {
                    pq.add(height[i + 1] - height[i]);
                    bricks -= height[i + 1] - height[i];
                } else { // else ladder has to be used where difference the heights of the building is maximum
                    if (ladders == 0) return i;
                    if (pq.size() == 0) {
                        ladders--;
                    } else {
                        if (pq.peek() > height[i + 1] - height[i]) {
                            bricks += pq.poll();
                            pq.add(height[i + 1] - height[i]);
                            bricks -= height[i + 1] - height[i];
                        }
                        ladders--;
                    }
                }
            }
        }
        return n-1;
    }
}
