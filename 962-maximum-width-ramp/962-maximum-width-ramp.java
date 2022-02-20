class Solution {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length, max = 0;
        Stack<Integer> st = new Stack<>();

        st.add(0);

        for (int i = 1; i < n; i++) {
            if (st.size() > 0 && nums[i] < nums[st.peek()]) {
                st.add(i);
            } else {
                int left = 0;

                int right = st.size() - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (nums[st.get(mid)] <= nums[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                
                max = Math.max(max, i - st.get(left));
            }
        }

        return max;
    }
}
