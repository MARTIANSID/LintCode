class Solution {

    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : tasks) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        Set<Integer> set = map.keySet();

        int ans = 0;
        for (int ele : set) {
            int freq = map.get(ele);
         
            if (freq < 3) {
                if (freq % 2 == 1) return -1;
                ans += freq / 2;
            } else {
                if (freq % 3 == 1) {
                     freq-=2;
                      ans += (freq / 3) + (((freq % 3)) / 2)  +1;
                } else {
                    ans += (freq / 3) + ((freq % 3)) / 2;
                }
            }
        }
        return ans;
    }
}
