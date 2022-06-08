class Solution {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        List<int[]> data = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            data.add(new int[] { values[i], labels[i] });
        }

        Collections.sort(
            data,
            (a, b) -> {
                return b[0] - a[0];
            }
        );

        int index = 0,ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (numWanted-- > 0 && index < n) {
            int[] arr = data.get(index++);
            int l = arr[1], v = arr[0];
            int freq = map.getOrDefault(l, 0);
            if (freq == useLimit) {
                numWanted++;
                continue;
            }
            map.put(l,freq+1);
            ans+=v;
        }
        
        return ans;
    }
}
