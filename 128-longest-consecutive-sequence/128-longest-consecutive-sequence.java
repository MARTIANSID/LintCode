class Solution {

    public int findParent(HashMap<Integer, Integer> map, int u) {
        if (map.get(u) == u) return u;

        int x = findParent(map, map.get(u));
        map.put(u, x);
        return x;
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        HashSet<Integer> set = new HashSet<>();

        for (int ele : nums) {
            map.put(ele, ele);
            set.add(ele);
        }

        int max = 0;

        for (int ele : nums) {
            if (set.contains(ele + 1)) {
                int p1 = findParent(map, ele);
                int p2 = findParent(map, ele + 1);
                if (p1 != p2) {
                    map.put(p1, p2);
                }
            }
        }
        HashSet<Integer> s = new HashSet<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int ele : nums) {
            if (!s.contains(ele)) {
                int p = findParent(map, ele);
                freq.put(p, freq.getOrDefault(p, 0) + 1);
                max = Math.max(max, freq.get(p));
                s.add(ele);
            }
        }

        return max;
    }
}
