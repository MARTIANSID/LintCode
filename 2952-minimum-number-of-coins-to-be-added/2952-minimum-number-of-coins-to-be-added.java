class Solution {

    public int minimumAddedCoins(int[] coins, int target) {
        int n = coins.length;
        int prevSum = 0, cnt = 0;
        Arrays.sort(coins);

        int no = 1;

        for (int i = 0; i < n; i++) {
            if (prevSum >= target) return cnt;
            if (prevSum + 1 < coins[i]) {
                // then we have to add an element
                prevSum += prevSum + 1;
                cnt++;
                i--;
            }else{
                prevSum += coins[i];
            }
            
        }

        while (prevSum < target) {
            prevSum += prevSum + 1;
            cnt++;
        }

        return cnt;
    }
}
// 1,2,3,4 -- 5
// 2,3,4,5
// 7+8=15+25
// [1,2,4,8,10]
// [1,4]
// prevSum = 0
// pevSum = 1
// no = 2
