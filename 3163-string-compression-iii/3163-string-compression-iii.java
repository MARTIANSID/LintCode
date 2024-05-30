class Solution {

    public String compressedString(String word) {
        int n = word.length(), i = 0;

        StringBuilder sb = new StringBuilder();

        while (i < n) {
            char ch = word.charAt(i);
            int cnt = 0;
            while (i < n && word.charAt(i) == ch) {
                i++;
                cnt++;
            }
            int maxTimes = cnt / 9;
            int rem = cnt % 9;

            while (maxTimes-- > 0) {
                sb.append("9" + ch);
            }
            if (rem > 0) {
                sb.append(rem + "" + ch);
            }
        }
        return sb.toString();
    }
}
