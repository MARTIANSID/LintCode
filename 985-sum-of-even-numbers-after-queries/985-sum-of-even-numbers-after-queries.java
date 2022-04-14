class Solution {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];

        int evenSum = 0;

        for (int ele : nums) {
            if (ele % 2 == 0) {
                evenSum += ele;
            }
        }

        int i = 0;
        for (int[] q : queries) {
            int val = q[0], index = q[1];
            boolean isEven = nums[index] % 2 == 0 ? true : false;
            int original = nums[index];
            nums[index] += val;
            boolean newEven = nums[index] % 2 == 0 ? true : false;

            if (!isEven && newEven) {
                evenSum += nums[index];
            } else if (isEven && newEven) {
                evenSum -= original;
                evenSum += nums[index];
            }else if(isEven && !newEven){
                evenSum -=original;
            }

            ans[i++] = evenSum;
        }
        return ans;
    }
}
