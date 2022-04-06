class Solution {

    

    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length, mod = (int) 1e9 + 7;
        int ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == target) {
                    int leftVal = arr[l], rightVal = arr[r];
                    int leftCount = 0, rightCount = 0;
                    while (l <= r && arr[l] == leftVal) {
                        l++;
                        leftCount++;
                    }
                    while (r >= l && arr[r] == rightVal) {
                        r--;
                        rightCount++;
                    }

                    if (leftVal == rightVal) {
                        
                        ans = (ans + (leftCount)*(leftCount-1)/2) % mod;
                    } else {
                        ans = (ans + leftCount * rightCount) % mod;
                    }
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
