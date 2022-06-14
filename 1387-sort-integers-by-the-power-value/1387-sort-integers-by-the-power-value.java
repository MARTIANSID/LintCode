class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    class pair {
        int n;
        int val;

        pair(int val, int n) {
            this.val = val;
            this.n = n;
        }
    }

    public int getKth(int lo, int hi, int k) {
        List<pair> ans = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            ans.add(new pair(solve(i), i));
        }
       
        Collections.sort(
            ans,
            (a, b) -> {
                return a.val - b.val;
            }
        );
        return ans.get(k - 1).n;
    }

    public int solve(int n) {
        if (n == 1) return 0;

        if (map.containsKey(n)) return map.get(n);

        if (n % 2 == 0) {
            map.put(n, solve(n / 2) + 1);
            return map.get(n);
        } else {
            map.put(n, solve(n * 3 + 1) + 1);
            return map.get(n);
        }
    }
}
