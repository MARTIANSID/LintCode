class Solution {

    public int countCollisions(String directions) {
        int n = directions.length(), collisions = 0;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = directions.charAt(i);
            if (st.size() > 0 && (st.peek() == 'S' || st.peek() == 'R') && ch == 'L') {
                collisions += (st.peek() == 'R') ? 2 : 1;

                st.pop();

                while (st.size() > 0 && st.peek() == 'R') {
                    st.pop();
                    collisions++;
                }
                st.push('S');
            } else if (st.size() > 0 && (st.peek() == 'R') && ch == 'S') {
                while (st.size() > 0 && st.peek() == 'R') {
                    collisions += 1;
                    st.pop();
                }
                st.push('S');
            } else {
                st.push(ch);
            }
        }
        return collisions;
    }
}
