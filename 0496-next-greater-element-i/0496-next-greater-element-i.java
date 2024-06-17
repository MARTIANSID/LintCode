class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        int[] nextRight = new int[n2];

        Arrays.fill(nextRight, -1);

        Stack<Integer> st = new Stack<>();

        for (int i = n2 - 1; i >= 0; i--) {
            while (st.size() > 0 && nums2[st.peek()] < nums2[i]) {
                st.pop();
            }

            if (st.size() > 0) {
                nextRight[i] = st.peek();
            }
            st.push(i);
        }

        int[] ans = new int[n1];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n2; i++) {
            map.put(nums2[i], i);
        }

        int i = 0;

        for (int ele : nums1) {
            int index = map.get(ele);
            ans[i++] = nextRight[index] == -1 ? -1 : nums2[nextRight[index]];
        }

        // System.out.println(Arrays.toString(nextRight));

        return ans;
    }
}
// nums2 = [1,3,4,2]
// nums1 = [4,1,2]
