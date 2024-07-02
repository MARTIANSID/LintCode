class Solution {

    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(
            clips,
            (a, b) -> {
                return a[0] - b[0];
            }
        );

        int startIndex = 0, cnt = 0, i = 0;

        while (i < clips.length) {
            cnt++;

            int max = -1;

            while (i < clips.length && clips[i][0] <= startIndex) {
                max = Math.max(max, clips[i][1]);
                i++;
            }
            
            startIndex = max;

            if (max >= time) {
                return cnt;
            }

            if (max == -1) {
                return -1;
            }
        }
        return -1;
    }
}
// we need 0 initially
// time interval = 2
//     end>= time
// [0,2],[1,9], [8,10]  start<=10 , max(endIndedx) - > [1,9]
// [[6,8],[5,6],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]]
// time = 20
// [0,20]
// startIndex <= 5
// startIndex <= 8
// [0,4], [5,7] , [6,9]
