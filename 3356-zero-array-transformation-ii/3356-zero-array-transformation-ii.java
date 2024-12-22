class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        
        int n = nums.length, m = queries.length;
        
        int si = 0, ei = queries.length-1, ans = -1;
        
        
        int sum = 0;
        
        for(int ele : nums) {
            sum += ele;
        }
        
        if(sum == 0) return 0;
        
        while(si<=ei) {
            int mid = (si+ei)/2;
            
            if(isPossible(nums,queries,mid)) {
                ans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        
        if(ans == -1) return ans;
        
        return ans + 1;

    }
    
    public boolean isPossible(int[] nums, int[][] queries, int mid) {
        
        int n = nums.length;
        
        int[] temp = new int[n];
        
        for(int i = 0; i <=mid; i++) {
            int[] query = queries[i];
            
            int l = query[0], r = query[1], val = query[2];
            
            temp[l] -= val;
            
            if(r+1 < n) {
                temp[r+1] += val; 
            }

            
            
        }
            int sum = 0;
        for(int i = 0; i < n; i++) {
                sum += temp[i];
                
                if(nums[i] + sum > 0) {

                    return false;
                }
        }
        return true;
    }
}

// binary search should work here