class Solution {

    public int maxProduct(String[] words) {
        int n = words.length;

        int[] masks = new int[n];

        int index = 0;

        for (String w : words) {
            int mask = 0;
            for (int i = 0; i < w.length(); i++) {
                char ch = w.charAt(i);
                masks[index] |= 1 << (ch - 'a');
            }
            index++;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    int x = 1 << k;
                    int b1 = (masks[i] & x) == 0 ? 0 : 1;
                    int b2 = (masks[j] & x) == 0 ? 0 : 1;
                    if (b1 == 1 && b2 == 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
