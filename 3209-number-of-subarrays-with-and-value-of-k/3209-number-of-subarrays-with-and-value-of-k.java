class Solution {

    public long countSubarrays(int[] nums, int k) {
        long ansK = slidingWindow(nums, k);
        long ansK1 = slidingWindow(nums, k + 1);

        // System.out.println(ansK + " " + ansK1);

        return ansK - ansK1;
    }

    public long slidingWindow(int[] nums, int k) {
        int si = 0, ei = 0, n = nums.length;

        long cnt = 0;

        int[] freq = new int[32];

        int and = nums[0];
        while (ei < n) {
            and &= nums[ei];

            for (int i = 0; i < 32; i++) {
                int x = (1 << i);
                int bit = (nums[ei] & x) == 0 ? 0 : 1;

                if (bit == 1) {
                    freq[i]++;
                }
            }
            
            ei++;

            while (si < ei && and < k) {
                for (int i = 0; i < 32; i++) {
                    int x = (1 << i);
                    int bit = (nums[si] & x) == 0 ? 0 : 1;

                    if (bit == 1) {
                        freq[i]--;
                    }
                }
                
                int no = 0;
                
                for (int i = 0; i < 32; i++) {
                    if(freq[i] == ei - si - 1) {
                        no += Math.pow(2,i);
                    }
                }
                
                and = no;
                si++;
                
            }

           cnt += (ei - si);
        }
        return cnt;
    }
}
