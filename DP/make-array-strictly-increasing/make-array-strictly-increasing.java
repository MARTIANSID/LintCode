class Solution {
   public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int res = dfs(arr1, Arrays.stream(arr2).distinct().sorted().toArray(), 0, Integer.MIN_VALUE, new HashMap<>());
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    private static int dfs(int[] arr1, int[] arr2, int i, int prev, Map<String, Integer> memo) {
        String key = i + "," + prev;
        if (memo.containsKey(key)) return memo.get(key);
        if (i >= arr1.length) return 0;
        int j = Arrays.binarySearch(arr2, prev);
        j = j < 0 ? -(j + 1) : j + 1;
        int bestWith = Integer.MAX_VALUE, bestWithout = Integer.MAX_VALUE;
        if (j < arr2.length) {
            bestWith = dfs(arr1, arr2, i + 1, arr2[j], memo);
            if (bestWith != Integer.MAX_VALUE) ++bestWith;
        }
        if (prev < arr1[i]) bestWithout = dfs(arr1, arr2, i + 1, arr1[i], memo);
        memo.put(key, Math.min(bestWith, bestWithout));
        return memo.get(key);
    }
}