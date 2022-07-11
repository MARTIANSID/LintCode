class Solution {

    public int minStartValue(int[] nums) {
        int n = nums.length;
        int si = 1, ei = (int) 1e5;

        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (isPossible(mid, nums)) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return si ;
    }

    public boolean isPossible(int mid, int[] nums) {
        for (int ele : nums) {
            mid += ele;
            if (mid < 1) return false;
        }

        return true;
    }
}
