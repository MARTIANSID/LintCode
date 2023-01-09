import java.util.HashMap;
import java.util.Set;

class Solution {
    public boolean isItPossible(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < n1; i++) {
            freq1[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n2; i++) {
            freq2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > 0) {
                for (int j = 0; j < 26; j++) {
                    if (freq2[j] > 0) {
                        freq1[i]--;
                        freq1[j]++;
                        freq2[j]--;
                        freq2[i]++;
                        int cnt1 = 0, cnt2 = 0;
                        for (int k = 0; k < 26; k++) {
                            if (freq1[k] > 0)
                                cnt1++;
                            if (freq2[k] > 0)
                                cnt2++;
                        }
                        if (cnt1 == cnt2)
                            return true;
                        freq1[i]++;
                        freq1[j]--;
                        freq2[j]++;
                        freq2[i]--;

                    }
                }
            }
        }
        return false;
    }
}