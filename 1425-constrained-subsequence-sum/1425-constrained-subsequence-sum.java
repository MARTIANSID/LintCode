import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        Deque<Integer> deq = new ArrayDeque<>();
        deq.addLast(0);
        for (int i = 1; i < n; i++) {
            while (deq.size() > 0 && i - deq.peekFirst() > k) deq.removeFirst();
            int max = dp[deq.peekFirst()];
            dp[i] = Math.max(max + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);

            while (deq.size() > 0 && dp[i] > dp[deq.peekLast()]) deq.removeLast();

            deq.addLast(i);
        }
        
        return ans;
    }
}
// O(n*k) brute force dp soln
// int n = nums.length;
// int[] dp = new int[n];
// dp[0] = nums[0];
// int ans=dp[0];
// for (int i = 1; i < n; i++) {
// int max=-(int)1e9;
// for (int j = i - 1; j >= Math.max(0, i - k); j--) {
// max = Math.max(max, dp[j]);
// }
// dp[i]=max+nums[i];
// ans=Math.max(ans,dp[i]);
// }
// return ans;
