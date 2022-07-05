class Solution {

    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;

        long sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sum += shifts[i];
            long j = s.charAt(i) - 'a';
            j = (j + sum) % 26;
            sb.append((char) (j + 'a'));
        }
        return new String(sb.reverse());
    }
}
