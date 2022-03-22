class Solution {

    public String getSmallestString(int n, int k) {
        
        StringBuilder sb=new StringBuilder();
        while (n > 0) {
            if (n != 1) {
                for (int i = 1; i <= 26; i++) {
                    int score = (int) (Math.ceil((double) ((double) (k - i) / (double) (n - 1))));

                    if (score <= 26) {
                        sb.append((char) ((i - 1) + 'a'));
                        k -= i;
                        break;
                    }
                }
            } else {
                sb.append((char) ((k - 1) + 'a'));
            }

            n--;
        }
        return new String(sb);
    }
}
