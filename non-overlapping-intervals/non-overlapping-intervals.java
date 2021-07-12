class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        
        
        
        int end=intervals[0][1];
        int ans=0;
        for(int i=1;i<intervals.length;i++){
                if(end>intervals[i][0]){
                    end=Math.min(end,intervals[i][1]);
                    ans++;
                }else{
                    end=Math.max(end,intervals[i][1]);
                }
        }
        
        return ans;
        
    }
}