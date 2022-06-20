class Solution {

    /*
    
    logic - simply traverse from start and check if we have the required character or not
    */
    
    public int minFlips(String s) {
        int n = s.length();
        boolean flip = false;
        int operations = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                if (flip) {} else {
                    operations++;
                    flip = !flip;
                }
            } else {
                if (!flip) {} else {
                    operations++;
                    flip = !flip;
                }
            }
        }

        return operations;
    }
}
