class Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> treel = new TreeMap<>();
        TreeMap<Integer, Integer> treeu = new TreeMap<>();

        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
    
            int l = lower-nums[i];
            int u = upper - nums[i];
            Integer ll = treel.ceilingKey(l);
        
            Integer up = treeu.floorKey(u);
            if (ll != null && up != null) {
                if (ll + nums[i] > upper) continue;
                ans += (treeu.get(up) - treel.get(ll) + 1);
            }
            
            treel.putIfAbsent(nums[i], i);
            treeu.put(nums[i], i);
        }

        return ans;
    }
}
