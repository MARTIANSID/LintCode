class Solution {

    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        for (int i = 0; i < n; i++) {
            while (st.size() > 0 && nums[i] <= nums[st.peek()]) st.pop();
            if (st.size() > 0) {
                left[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && nums[i] <= nums[st.peek()]) st.pop();
            if (st.size() > 0) {
                right[i] = st.peek();
            }
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            int l = left[i], r = right[i];
           
            int len = r - l - 1;
            if ((double) nums[i] > (double) ((double) threshold / (double) len)) return len;
        }
        return -1;
    }
}
// threshold=2
