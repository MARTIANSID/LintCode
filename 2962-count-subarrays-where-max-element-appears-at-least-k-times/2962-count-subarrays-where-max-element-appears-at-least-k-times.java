class Solution {

    public long countSubarrays(int[] nums, int k) {
        int n = nums.length, max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int si = 0, ei = 0, cnt = 0;
        long subArrays = 0;

        while (ei < n) {
            int ele = nums[ei++];

            if (ele == max) cnt += 1;
            
            while(cnt >= k){
                subArrays += (n-ei+1);
                
                if(nums[si++] == max){
                    cnt--;
                }
            }
        }
        return subArrays;
    }
}
