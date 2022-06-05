class Solution {
    HashMap<Integer, Integer> map;
    HashSet<Integer> set;
    Random rand;

    int size;

    public Solution(int n, int[] blacklist) {
        n--;
        this.rand = new Random();
        this.set = new HashSet<>();
        this.map=new HashMap<>();
        Arrays.sort(blacklist);
        for (int ele : blacklist) set.add(ele);
        int m = blacklist.length;
        int upper = n - m;
        size = upper;
        int val = upper + 1;
        for (int ele : blacklist) {
            if (ele <= upper) {
                while (set.contains(val)) val++;
                map.put(ele, val);
                val++;
            }
        }
    }

    public int pick() {
        int random = rand.nextInt(size + 1);
        if (map.containsKey(random)) return map.get(random); else return random;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
