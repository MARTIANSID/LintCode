class Solution {
    Integer[][] dp;

    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;

        int[][] freq = new int[n][26];

        dp = new Integer[n][(int) (Math.pow(2, target.length()))];

        int index = 0;

        for (String sticker : stickers) {
            freq[index] = new int[26];
            for (int i = 0; i < sticker.length(); i++) {
                char ch = sticker.charAt(i);

                freq[index][ch - 'a']++;
            }
            index++;
        }

        int ans = dfs(freq, 0, 0, target.length(), target);

        return ans == (int) 1e9 ? -1 : ans;
    }

    public int dfs(int[][] freq, int index, int mask, int targetLength, String target) {
        if (index == freq.length) {
            for (int i = 0; i < targetLength; i++) {
                int x = (1 << i);

                int bit = (mask & x) == 0 ? 0 : 1;

                if (bit == 0) {
                    return (int) 1e9;
                }
            }
            return 0;
        }

        if (dp[index][mask] != null) return dp[index][mask];

        //skip
        int skip = dfs(freq, index + 1, mask, targetLength, target);

        int[] freq_temp = new int[26];

        //         "thehat" - > "100001"

        //         {
        //             h : 2,
        //             e : 1
        //             a : 1
        //         }

        //pick
        for (int i = 0; i < targetLength; i++) {
            int x = (1 << i);

            int bit = (mask & x) == 0 ? 0 : 1;

            if (bit == 0) {
                freq_temp[target.charAt(i) - 'a']++;
            }
        }

        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        HashMap<Character, Integer> copyMap = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            if (freq_temp[i] >= 1 && freq[index][i] >= 1) {
                max = Math.max(max, freq_temp[i]);
                map.put((char) (i + 'a'), 1);
                copyMap.put((char) (i + 'a'), 1);
            }
        }

        Set<Character> set = copyMap.keySet();

        int localMin = (int) 1e9;

        int originalMask = mask;

        for (int tempMax = 1; tempMax <= max; tempMax++) {
            for (Character key : set) {
                map.put(key, tempMax * freq[index][key - 'a']);
            }

            for (int i = 0; i < targetLength; i++) {
                int x = (1 << i);

                int bit = (mask & x) == 0 ? 0 : 1;

                if (bit == 0) {
                    char ch = target.charAt(i);

                    if (map.containsKey(ch)) {
                        mask = mask | x;
                        int f = map.get(ch);
                        f--;

                        if (f == 0) {
                            map.remove(ch);
                        } else {
                            map.put(ch, f);
                        }
                    }
                }
            }

            localMin = Math.min(localMin, dfs(freq, index + 1, mask, targetLength, target) + tempMax);

            mask = originalMask;
        }

        return dp[index][mask] = Math.min(localMin, skip);
    }
}
// "with" - > []
// "with" = 26 - > a -> z
// w : 1
// i : 1
// t : 2
// h : 2
// {
//     t : 2
//     h : 2
//     e : 1
//     a : 1
// }
// 2 options
// skip the sticker
// inlcude sticker - (how many sticker of this type?) - try to take max possible no of stickers
// index, state of targetWord (how do we store this state?) -> bitmask
//  "thehat"   - > 110101 - >
// dfs():
//     dfs() -- skip
//     dfs() -- pick
// 2^15 - >  32k
