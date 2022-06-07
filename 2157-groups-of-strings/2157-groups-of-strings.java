class Solution {

    public int calculateMask(String w) {
        int mask = 0;
        for (int i = 0; i < w.length(); i++) {
            int index = w.charAt(i) - 'a';
            int x = 1 << index;
            mask |= x;
        }
        return mask;
    }

    public int findParent(int[] parent, int u) {
        if (parent[u] == u) {
            return u;
        }
        int x = findParent(parent, parent[u]);
        parent[u] = x;
        return x;
    }

    public int[] groupStrings(String[] words) {
        int n = words.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<String, Integer> wToMask = new HashMap<>();

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            //calculate mask of each word
            int mask = calculateMask(words[i]); //tc : O(26)
            wToMask.put(words[i], mask);
            map.put(mask, i);
        }

        int k = 0;

        // no need to add a character because from the larger string we will remove the character and it will form the lower length string

        for (String w : words) {
            int mask = wToMask.get(w);
            //2.Remove A character
            for (int i = 0; i < 26; i++) {
                int x = (1 << i);
                int bit = (mask & x) == 0 ? 0 : 1;
                if (bit == 1) {
                    if (map.containsKey((mask&(~x)))) {
                        int index = map.get((mask&(~x)));
                        int p1 = findParent(parent, index);
                        int p2 = findParent(parent, k);
                        if (p1 != p2) {
                            parent[p1] = p2;
                        }
                    }
                }
            }
            

            //3.replace A character by anyother character
            for (int i = 0; i < 26; i++) {
                int x = (1 << i);
                int bit = (mask & x) == 0 ? 0 : 1;
                int newMask = (mask & (~x));
                   
                if (bit == 1) {
                    for (int j = 0; j < 26; j++) {
                        int y = (1 << j);
                        int bit1 = (newMask & y) == 0 ? 0 : 1;
                        if (bit1 == 0) {
                            if (map.containsKey((newMask | y))) {
                                int index = map.get((newMask | y));
                                int p1 = findParent(parent, index);
                                int p2 = findParent(parent, k);
                                if (p1 != p2) {
                                    parent[p1] = p2;
                                }
                            }
                        }
                    }
                }
            }
            
            k++;
        }
        int[] ans = new int[2];
        int max = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = findParent(parent, i);
            freq.put(p, freq.getOrDefault(p, 0) + 1);
            max = Math.max(max, freq.get(p));
        }
        

        ans[0] = freq.size();
        ans[1] = max;
        return ans;
    }
}
