class Solution {

    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length, index = 0;

        int[] ans = new int[n];

        HashMap<Integer, Integer> colors = new HashMap<>();

        HashMap<Integer, Integer> map = new HashMap<>(); // color : freq

        for (int[] query : queries) {
            int ball = query[0], color = query[1];

            if (colors.containsKey(ball) && colors.get(ball) == color) {
                ans[index++] = map.size();
                continue;
            }

            if (!colors.containsKey(ball)) {
                map.put(color, map.getOrDefault(color, 0) + 1);
            } else {
                int freq = map.get(colors.get(ball)) - 1;

                if (freq == 0) {
                    map.remove(colors.get(ball));
                } else {
                    map.put(colors.get(ball), freq);
                }
                map.put(color, map.getOrDefault(color, 0) + 1);
            }
            colors.put(ball, color);
            ans[index++] = map.size();
        }
        return ans;
    }
}
