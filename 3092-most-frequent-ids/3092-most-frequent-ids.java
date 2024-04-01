class Solution {

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;

        TreeMap<Long, HashSet<Integer>> tree = new TreeMap<>(); // freq to elements
        HashMap<Integer, Long> map = new HashMap<>(); // elements to freq

        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            int ele = nums[i];

            long oldFreq = map.getOrDefault(nums[i], (long) 0);

            long change = freq[i];
            long newFrequency = oldFreq + change;
            
            map.put(ele,newFrequency);

            if (newFrequency != oldFreq) {
                if (oldFreq != 0) {
                    tree.get(oldFreq).remove(ele);

                    if (tree.get(oldFreq).size() == 0) {
                        tree.remove(oldFreq);
                    }
                }
            }

            if (!tree.containsKey(newFrequency)) {
                tree.put(newFrequency, new HashSet<>());
            }

            tree.get(newFrequency).add(ele);


            ans[i] = tree.lastKey();
        }
        return ans;
    }
}
// 2,3 - > 2,0
// 3,2
// 1,1
