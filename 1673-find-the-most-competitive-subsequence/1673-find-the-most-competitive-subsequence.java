import java.util.*;

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int ele = nums[i];
                while (st.size() > 0 && st.peek() > ele && st.size() + n - i - 1  >= k)
                    st.pop();
                if (st.size() < k)
                    st.push(ele);
            }
        
        int[] ans = new int[st.size()];
        int index = st.size() - 1;
        while (st.size() > 0) {
            ans[index--] = st.pop();
        }
        return ans;
    }
}