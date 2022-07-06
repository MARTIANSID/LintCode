class Solution {

    public List<String> simplifiedFractions(int n) {
        HashSet<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            for (int j =i+1; j <=n; j++) {
                int x = j, y = i;
                int highestCommonFactor = gcd(x, y);
                x = x / highestCommonFactor;
                y = y / highestCommonFactor;
                if (set.contains(y + "/" + x)) continue;
                ans.add(y + "/" + x);
                set.add(y + "/" + x);
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
