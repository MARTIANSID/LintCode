class Solution {
    /*
     eg a->6    aabaabaa
        b->2
    */
    public String strWithout3a3b(int a, int b) {
        boolean flag = a > b ? false : true;
        StringBuilder sb = new StringBuilder();
        while (a > 0 && b > 0) {
            if (!flag) {
                a--;
                sb.append('a');
                if (a >= b) {
                    sb.append('a');
                    a--;
                }
            } else {
                b--;
                sb.append('b');
                if (b >= a) {
                    sb.append('b');
                    b--;
                }
            }
            flag = !flag;
        }
        while (a-- > 0) sb.append('a');
        while (b-- > 0) sb.append('b');

        return new String(sb);
    }
}
