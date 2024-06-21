class Solution {
    Integer[][] dp;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        
        dp = new Integer[books.length+1][shelfWidth+1];
        
        return solve(books, 0, 0, shelfWidth, 0);
    }

    public int solve(int[][] books, int index, int width, int shelfWidth, int max) {
        if (index == books.length) {
            return max;
        }
        
        if(dp[index][width] != null) return dp[index][width];

        int currentBookWidth = books[index][0], currentBookHeight = books[index][1];

        // can i place it in the current shelf

        int cnt = (int) 1e9;

        if (width + currentBookWidth <= shelfWidth) {
            cnt = solve(books, index + 1, width + currentBookWidth, shelfWidth, Math.max(max, currentBookHeight));
        }

        // place in the next shelf
        return dp[index][width] = Math.min(cnt, solve(books, index + 1, currentBookWidth, shelfWidth, currentBookHeight) + max);
    }
}
// [bookNo][widthOfTheCurrentLevel]
//                 1 - > 3
//                 [1] [2]   > 2
//             [1] [2,3]   [1] [2] [3]
