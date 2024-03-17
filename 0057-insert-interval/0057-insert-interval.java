class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> ans = new ArrayList<>();
        
        List<int[]> newIntervals = new ArrayList<>();
        
        
        for(int[] interval : intervals){
            
            newIntervals.add(interval);
        }
        
        newIntervals.add(newInterval);
        
        Collections.sort(newIntervals,(a,b)->{
           return a[0] - b[0];
        });
        
        int s = newIntervals.get(0)[0], e = newIntervals.get(0)[1];
        
        for(int i = 1; i < newIntervals.size(); i++){
            
            int currS = newIntervals.get(i)[0];
            int currE = newIntervals.get(i)[1];
            
            
            if(e < currS){
                ans.add(new int[]{s,e});
                e = currE;
                s = currS;
            }else {
                e = Math.max(e,currE);
            }
        }
        ans.add(new int[]{s,e});
        
        int[][] result = new int[ans.size()][2];
        
        
        int index = 0;
        
        for(int[] temp : ans){
            result[index++] = temp;
        }
        return result;
        
    }
}